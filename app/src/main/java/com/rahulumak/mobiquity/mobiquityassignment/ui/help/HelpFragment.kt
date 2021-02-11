package com.rahulumak.mobiquity.mobiquityassignment.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahulumak.mobiquity.mobiquityassignment.R
import kotlinx.android.synthetic.main.fragment_help.view.*

class HelpFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_help, container, false)
        root.webView.loadUrl("file:///android_asset/help.html")
        return root
    }
}