package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adaptumapp.R
import com.example.adaptumapp.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

//    @Inject
//    lateinit var viewModel: ProfileFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        (requireActivity().application as SynergySportApp).appComponent.inject(this)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        bindViewModel()
//        viewModel.init()


//    private fun bindViewModel() {
//        viewModel.profileInfoLiveData.observe(viewLifecycleOwner) {
//            with(binding) {
//                name.text = it.fullName
//                telegram.text = it.telegram
//                roleStrTv.text = it.roleStr
//                companyNameTv.text = it.company
//                mailTv.text = it.email
//            }
//        }
//    }
}