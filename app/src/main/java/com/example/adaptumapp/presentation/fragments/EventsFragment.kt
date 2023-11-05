package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.databinding.FragmentEventsBinding
import com.example.adaptumapp.presentation.adapters.EventsListAdapter
import com.example.adaptumapp.presentation.viewModels.EventsFragmentViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding

    private lateinit var eventsAdapter: EventsListAdapter

    @Inject
    lateinit var viewModel: EventsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        eventsAdapter = EventsListAdapter()
        eventsAdapter.registerAction = {
            viewModel.onClickRegister(it)
        }
        binding.eventsRv.adapter = eventsAdapter

    }

    private fun bindViewModel() {
        lifecycleScope.launch {
            viewModel.eventsState.flowWithLifecycle(
                lifecycle,
                Lifecycle.State.RESUMED
            ).filterNotNull()
                .collectLatest {
                    eventsAdapter.submitList(it)
                }
        }
    }
}