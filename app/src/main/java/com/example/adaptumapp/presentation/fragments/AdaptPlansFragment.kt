package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.databinding.FragmentAdaptPlansBinding
import com.example.adaptumapp.presentation.adapters.AdaptPlansListAdapter
import com.example.adaptumapp.presentation.common.Navigator
import com.example.adaptumapp.presentation.common.collectFlow
import com.example.adaptumapp.presentation.viewModels.AdaptPlansFragmentViewModel
import javax.inject.Inject

class AdaptPlansFragment : Fragment() {

    private lateinit var binding: FragmentAdaptPlansBinding

    private lateinit var adaptPlansListAdapter: AdaptPlansListAdapter

    @Inject
    lateinit var viewModel: AdaptPlansFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdaptPlansBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        bindViewModel()
        viewModel.init()
    }

    private fun initRecyclerView() {
        adaptPlansListAdapter = AdaptPlansListAdapter()
        binding.tasksRv.adapter = adaptPlansListAdapter
        adaptPlansListAdapter.onClickAction = {
            Navigator.navigateReplaceSaveStack(
                StagesFragment.newInstance(it),
                parentFragmentManager
            )
        }
        adaptPlansListAdapter.onClickSendMessageAction = {
            Navigator.navigateReplaceSaveStack(HelpFragment(), parentFragmentManager)
        }
    }

    fun bindViewModel() {
        collectFlow(viewModel.adaptListState) {
            adaptPlansListAdapter.submitList(it)
        }
    }
}