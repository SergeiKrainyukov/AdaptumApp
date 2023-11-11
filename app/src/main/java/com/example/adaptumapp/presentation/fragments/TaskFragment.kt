package com.example.adaptumapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.adaptumapp.R
import com.example.adaptumapp.presentation.common.Navigator

class TaskFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.start_timer_btn).setOnClickListener {
            Navigator.navigateReplaceSaveStack(TrackerFragment(), parentFragmentManager)
        }
        view.findViewById<Button>(R.id.accept_task_btn).setOnClickListener {
            Navigator.closeFragment(parentFragmentManager)
        }
        val mWebView = view.findViewById(R.id.videoView) as WebView

        val videoStr =
            "<html><body>Promo video<br><iframe width=\"360\" height=\"240\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\" frameborder=\"0\" allowfullscreen></iframe></body></html>"

        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        val ws: WebSettings = mWebView.settings
        ws.javaScriptEnabled = true
        mWebView.loadData(videoStr, "text/html", "utf-8")
    }
}