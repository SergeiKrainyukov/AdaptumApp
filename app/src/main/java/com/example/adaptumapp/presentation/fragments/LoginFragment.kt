package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.databinding.FragmentLoginBinding
import com.example.adaptumapp.presentation.common.Navigator
import com.example.adaptumapp.presentation.common.ToolbarVisibilityListener
import com.example.adaptumapp.presentation.common.collectFlow
import com.example.adaptumapp.presentation.common.showToast
import com.example.adaptumapp.presentation.viewModels.LoginFragmentViewModel
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var viewModel: LoginFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        (requireActivity() as? ToolbarVisibilityListener)?.hideToolbar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
    }

    private fun initViews() {
        binding.submitButton.setOnClickListener {
            viewModel.onClickAuth(
                binding.loginTv.text.toString(),
                binding.passwordTv.text.toString()
            )
        }
    }

    private fun bindViewModel() {
        collectFlow(viewModel.authStatusState) {
            if (it) openPlansScreen()
            else showToast("Error")
        }
    }

    private fun openPlansScreen() {
        Navigator.navigateReplace(AdaptPlansFragment(), parentFragmentManager)
        (requireActivity() as? ToolbarVisibilityListener)?.showToolbar()
    }
}