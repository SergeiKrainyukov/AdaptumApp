package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptumapp.R
import com.example.adaptumapp.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private lateinit var binding: FragmentHelpBinding
    private lateinit var messageListAdapter: MessageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mentorNameTv.text = arguments?.getString(NAME_ARG)

        messageListAdapter = MessageListAdapter()
        messageListAdapter.messageList = listOf(
            Message("Привет, нужна помощь по первой стадии плана", true),
            Message("Привет, освобожусь в 12:00, тогда пообщаемся", false),
            Message("Хорошо, договорились", true),
        )
        binding.chatRecyclerView.adapter = messageListAdapter
    }

    companion object {

        private const val NAME_ARG = "NAME_ARG"

        fun getInstance(name: String) = HelpFragment().apply {
            arguments = Bundle().apply {
                putString(NAME_ARG, name)
            }
        }


    }
}

class MessageListAdapter : RecyclerView.Adapter<MessageListAdapter.MessageItemViewHolder>() {

    var messageList = listOf<Message>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_SENT -> R.layout.item_message_sent
            VIEW_TYPE_RECEIVED -> R.layout.item_message_received
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MessageItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MessageItemViewHolder, position: Int) {
        val message = messageList[position]
        viewHolder.view.setOnLongClickListener {
            true
        }
        viewHolder.tvMessage.text = message.message
    }

    override fun onViewRecycled(viewHolder: MessageItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.tvMessage.text = ""
        viewHolder.tvMessage.setTextColor(
            ContextCompat.getColor(
                viewHolder.view.context,
                android.R.color.white
            )
        )
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = messageList[position]
        return if (item.isSent) {
            VIEW_TYPE_SENT
        } else {
            VIEW_TYPE_RECEIVED
        }
    }

    class MessageItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvMessage = view.findViewById<TextView>(R.id.message_tv)
    }

    companion object {
        const val VIEW_TYPE_RECEIVED = 100
        const val VIEW_TYPE_SENT = 101
    }
}

data class Message(var message: String, val isSent: Boolean)