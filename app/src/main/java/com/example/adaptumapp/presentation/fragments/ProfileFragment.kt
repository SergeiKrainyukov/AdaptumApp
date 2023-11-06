package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.R
import com.example.adaptumapp.databinding.FragmentProfileBinding
import com.example.adaptumapp.presentation.common.Navigator
import com.example.adaptumapp.presentation.model.ProfileDataUI
import com.example.adaptumapp.presentation.viewModels.ProfileFragmentViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    @Inject
    lateinit var viewModel: ProfileFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        viewModel.init()
    }

    private fun bindViewModel() {
        lifecycleScope.launch {
            viewModel.profileDataState.flowWithLifecycle(
                lifecycle,
                Lifecycle.State.RESUMED
            ).filterNotNull()
                .collectLatest {
                    setViews(it)
                }
        }
    }

    private fun setViews(profileDataUI: ProfileDataUI) {
        with(binding) {
            with(profileDataUI) {
                if (avatarUrl.isNotBlank()) Glide.with(requireContext()).load(avatarUrl)
                    .into(avatar)
                nameTv.text = name
                with(profileAdditionalInfoJobLayout) {
                    title.text = getString(R.string.job)
                    description.text = profileDataUI.job
                    icon.setImageResource(R.drawable.ic_work)
                }
                with(profileAdditionalInfoOrganizationLayout) {
                    title.text = getString(R.string.organization)
                    description.text = profileDataUI.organization
                    icon.setImageResource(R.drawable.ic_business)
                }
                with(profileAdditionalInfoMailLayout) {
                    title.text = getString(R.string.mail)
                    description.text = profileDataUI.mail
                    icon.setImageResource(R.drawable.ic_mail)
                }
                with(profileAdditionalInfoCityLayout) {
                    title.text = getString(R.string.city)
                    description.text = profileDataUI.city
                    icon.setImageResource(R.drawable.ic_city)
                }
                logoutBtn.setOnClickListener {
                    Navigator.navigateReplace(LoginFragment(), parentFragmentManager)
                }
            }
        }
    }


}