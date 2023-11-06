package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.R
import com.example.adaptumapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
    }

    private fun initViews() {
        binding.submitButton.setOnClickListener {
            val login = binding.loginTv.text.toString()
            val password = binding.passwordTv.text.toString()
//            viewModel.onClickAuth(login, password)
        }
    }

    private fun bindViewModel() {
//        with(viewModel) {
//            onClickAuthLiveData.observe(viewLifecycleOwner) {
//                Navigator.navigateReplace(StartTrainingFragment(), parentFragmentManager)
//                (requireActivity() as? ToolbarVisibilityListener)?.showToolbar()
//            }
//            errorAuthLiveData.observe(viewLifecycleOwner) {
//                showErrorAuthMessage()
//            }
//        }
    }

    private fun showErrorAuthMessage() {
        Toast.makeText(requireContext(), getString(R.string.error_auth_message), Toast.LENGTH_LONG)
            .show()
    }
}