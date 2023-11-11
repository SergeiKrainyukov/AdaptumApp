package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.databinding.FragmentAdaptPlansBinding
import com.example.adaptumapp.presentation.viewModels.AdaptPlansFragmentViewModel
import javax.inject.Inject

class AdaptPlansFragment : Fragment() {

    private lateinit var binding: FragmentAdaptPlansBinding

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
}