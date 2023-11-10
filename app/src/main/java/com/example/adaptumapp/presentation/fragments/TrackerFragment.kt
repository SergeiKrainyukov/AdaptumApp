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
import com.example.adaptumapp.R
import com.example.adaptumapp.databinding.FragmentTrackerBinding
import com.example.adaptumapp.presentation.viewModels.TaskFragmentViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrackerFragment : Fragment() {
    private lateinit var binding: FragmentTrackerBinding

    @Inject
    lateinit var viewModel: TaskFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackerBinding.inflate(inflater, container, false)
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
        binding.pauseButton.apply {
            setOnClickListener {
                viewModel.onClickPauseResume()
                setImageResource(if (viewModel.isStarted) R.drawable.ic_pause else R.drawable.ic_play)
            }
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
            lifecycleScope.launch {
                viewModel.timeCountState.flowWithLifecycle(
                    lifecycle,
                    Lifecycle.State.RESUMED
                ).filterNotNull()
                    .collectLatest {
                        binding.currentMetricValue.text = it.toString()
                    }
            }
        }
    }
}