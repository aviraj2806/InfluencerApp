package com.zila.influencerapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.zila.influencerapp.R
import com.zila.influencerapp.adapter.MonthAdapter
import com.zila.influencerapp.adapter.VideoDetailsAdapter
import com.zila.influencerapp.adapter.YearAdapter
import com.zila.influencerapp.model.VideoDetailsData
import com.zila.influencerapp.model.YearData

class VideoDetailsFragment : Fragment() {

    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: VideoDetailsAdapter
    val resInfoList = arrayListOf<VideoDetailsData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video_details, container, false)
        recyclerHome = view.findViewById(R.id.listVideoDetails)
        layoutManager = LinearLayoutManager(activity)

        recyclerHome.visibility = View.GONE
        recyclerHome.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_up_in))
        recyclerHome.visibility = View.VISIBLE

        resInfoList.add(VideoDetailsData("5 reasons to buy iPhone 11","500","accepted"))
        resInfoList.add(VideoDetailsData("Is Dell 7565 a good laptop?","0","rejected"))
        resInfoList.add(VideoDetailsData("The new One Plus TV","800","accepted"))
        resInfoList.add(VideoDetailsData("Why MI in Mobiles?","0","rejected"))

        recyclerAdapter = VideoDetailsAdapter(activity as Context,resInfoList)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager

        return view
    }

}
