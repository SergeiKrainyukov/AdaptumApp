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
import com.example.adaptumapp.presentation.viewModels.TasksFragmentViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding

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
            viewModel.trainingsState.flowWithLifecycle(
                lifecycle,
                Lifecycle.State.RESUMED
            ).filterNotNull()
                .collectLatest {

                }
        }
    }

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {

    }
}

//class TrainingsFragment : Fragment(R.layout.fragment_trainings) {
//
//    private lateinit var trainingsListAdapter: TrainingsListAdapter
//
//    private lateinit var binding: FragmentTrainingsBinding
//
//    @Inject
//    lateinit var viewModel: TrainingsFragmentViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        (requireActivity().application as SynergySportApp).appComponent.inject(this)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentTrainingsBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initViews()
//        bindViewModel()
//        viewModel.init()
//    }
//
//    private fun bindViewModel() {
//        viewModel.trainingsLiveData.observe(viewLifecycleOwner) {
//            trainingsListAdapter.submitList(
//                it
//            )
//        }
//    }
//
//    private fun initViews() {
//        initRecyclerView()
//    }
//
//    private fun initRecyclerView() {
//        trainingsListAdapter = TrainingsListAdapter()
//        with(binding.trainingsRv) {
//            adapter = trainingsListAdapter
//        }
//    }
//}