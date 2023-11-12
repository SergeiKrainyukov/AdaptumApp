package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.databinding.FragmentStagesBinding
import com.example.adaptumapp.presentation.adapters.TasksListAdapter
import com.example.adaptumapp.presentation.common.Navigator
import com.example.adaptumapp.presentation.common.collectFlow
import com.example.adaptumapp.presentation.viewModels.StagesFragmentViewModel
import javax.inject.Inject

class StagesFragment : Fragment() {

    private lateinit var binding: FragmentStagesBinding
    private lateinit var tasksListAdapter: TasksListAdapter

    @Inject
    lateinit var viewModel: StagesFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
        arguments?.getInt(GROUP_ID)?.let { viewModel.init(it) }
    }

    private fun bindViewModel() {
        collectFlow(viewModel.stagesState) {
            tasksListAdapter.submitList(it)
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
        tasksListAdapter.onClickStage = {
            Navigator.navigateReplaceSaveStack(StageFragment.getInstance(it), parentFragmentManager)
        }
    }

    companion object {

        private const val GROUP_ID = "GROUP_ID"

        fun newInstance(groupId: Int) = StagesFragment().apply {
            arguments = Bundle().apply {
                putInt(GROUP_ID, groupId)
            }
        }
    }
}