package com.zila.influencerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import com.zila.influencerapp.R

class SubmitVideoFragment : Fragment() {

    lateinit var llUploadVide: LinearLayout
    lateinit var btnPublish: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_submit_video, container, false)
        llUploadVide = view.findViewById(R.id.llUploadVideo)
        btnPublish = view.findViewById(R.id.btnPublish)

        llUploadVide.visibility = View.GONE
        llUploadVide.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_up_in))
        llUploadVide.visibility = View.VISIBLE

        btnPublish.setOnClickListener {
            val inflater: LayoutInflater = layoutInflater
            val root: View = inflater.inflate(R.layout.toast, null)
            val toast = Toast(activity)
            root.findViewById<TextView>(R.id.toast_text).text = "Feature Not Developed."
            toast.view = root
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }

        return view
    }

}
