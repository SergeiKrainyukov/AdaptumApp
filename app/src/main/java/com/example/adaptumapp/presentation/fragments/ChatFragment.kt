package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adaptumapp.databinding.FragmentChatBinding
import com.example.adaptumapp.presentation.adapters.MessageListAdapter
import com.example.adaptumapp.presentation.model.MessageListItem

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private lateinit var messageListAdapter: MessageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.mentorNameTv.text = arguments?.getInt(MENTOR_ID_ARG).toString()

        messageListAdapter = MessageListAdapter()
        messageListAdapter.messageListItemList = listOf(
            MessageListItem("Привет, нужна помощь по первой стадии плана", true),
            MessageListItem("Привет, освобожусь в 12:00, тогда пообщаемся", false),
            MessageListItem("Хорошо, договорились", true),
        )
        binding.chatRecyclerView.adapter = messageListAdapter
    }

    companion object {

        private const val MENTOR_ID_ARG = "MENTOR_ID_ARG"

        fun getInstance(mentorId: Int) = ChatFragment().apply {
            arguments = Bundle().apply {
                putInt(MENTOR_ID_ARG, mentorId)
            }
        }

    }
}