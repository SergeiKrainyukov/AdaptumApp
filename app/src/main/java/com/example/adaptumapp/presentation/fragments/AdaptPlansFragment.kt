package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adaptumapp.databinding.FragmentAdaptPlansBinding

class AdaptPlansFragment : Fragment() {

    private lateinit var binding: FragmentAdaptPlansBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdaptPlansBinding.inflate(inflater, container, false)
        return binding.root
    }
}