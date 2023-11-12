package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.adaptumapp.AdaptumApp
import com.example.adaptumapp.databinding.FragmentStageBinding
import com.example.adaptumapp.presentation.common.Navigator
import com.example.adaptumapp.presentation.common.collectFlow
import com.example.adaptumapp.presentation.model.StageDataUI
import com.example.adaptumapp.presentation.viewModels.StageFragmentViewModel
import javax.inject.Inject

class StageFragment : Fragment() {

    private lateinit var binding: FragmentStageBinding

    @Inject
    lateinit var viewModel: StageFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as AdaptumApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        arguments?.getInt(ID_PARAM)?.let { viewModel.init(it) }
    }

    private fun bindViewModel() {
        collectFlow(viewModel.stageDataState) {
            it?.let { it1 -> setViews(it1) }
        }
    }

    private fun setViews(stageDataUI: StageDataUI) {
        with(binding) {
            titleTv.text = stageDataUI.title
            descriptionTv.text = stageDataUI.description
            url.text = stageDataUI.documentUrl
            startTimerBtn.setOnClickListener {
                Navigator.navigateReplaceSaveStack(TrackerFragment(), parentFragmentManager)
            }
            acceptTaskBtn.setOnClickListener {
                Navigator.closeFragment(parentFragmentManager)
            }
            val videoStr =
                "<html><body>Promo video<br><iframe width=\"360\" height=\"240\" src=\"${stageDataUI.videoUrl}\" frameborder=\"0\" allowfullscreen></iframe></body></html>"
            videoView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    return false
                }
            }
            videoView.settings.javaScriptEnabled = true
            videoView.loadData(videoStr, "text/html", "utf-8")
        }
    }

    companion object {

        private const val ID_PARAM = "ID_PARAM"

        fun getInstance(id: Int) = StageFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_PARAM, id)
            }
        }
    }
}