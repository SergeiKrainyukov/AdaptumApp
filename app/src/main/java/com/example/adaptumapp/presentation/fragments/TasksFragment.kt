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
import com.example.adaptumapp.databinding.FragmentTasksBinding
import com.example.adaptumapp.presentation.adapters.TasksListAdapter
import com.example.adaptumapp.presentation.viewModels.TasksFragmentViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding

    private lateinit var tasksListAdapter: TasksListAdapter

    @Inject
    lateinit var viewModel: TasksFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun bindViewModel() {
        lifecycleScope.launch {
            viewModel.tasksState.flowWithLifecycle(
                lifecycle,
                Lifecycle.State.RESUMED
            ).filterNotNull()
                .collectLatest {
                    tasksListAdapter.submitList(it)
                }
        }
    }

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        tasksListAdapter = TasksListAdapter()
        with(binding.tasksRv) {
            adapter = tasksListAdapter
        }
    }
}