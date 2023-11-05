package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.R
import com.example.adaptumapp.databinding.FragmentTaskBinding
import com.example.adaptumapp.presentation.viewModels.TaskFragmentViewModel
import com.example.adaptumapp.presentation.viewModels.TasksFragmentViewModel
import javax.inject.Inject

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    @Inject
    lateinit var viewModel: TaskFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews() {
        initPauseButton()
        initStopButton()
    }

    private fun initPauseButton() {
        binding.pauseButton.setOnClickListener {
            viewModel.onClickPauseResume()
        }
    }

    private fun initStopButton() {
        with(binding.stopButton) {
            setOnClickListener {
                viewModel.onClickStop()
            }
            visibility = View.GONE
        }
    }

    private fun bindViewModel() {
        with(viewModel) {

        }
    }
}