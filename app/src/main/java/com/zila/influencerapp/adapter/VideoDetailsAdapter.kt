package com.zila.influencerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zila.influencerapp.R
import com.zila.influencerapp.model.VideoDetailsData

class VideoDetailsAdapter(val context:Context,val itemList:ArrayList<VideoDetailsData>) : RecyclerView.Adapter<VideoDetailsAdapter.VideoDetailsViewHolder>() {

    class VideoDetailsViewHolder(val view:View) : RecyclerView.ViewHolder(view){
        val txtVDTopic: TextView = view.findViewById(R.id.txtVDTopic)
        val txtVDStatus: TextView = view.findViewById(R.id.txtVDStatus)
        val txtVDEarn: TextView = view.findViewById(R.id.txtVDEarn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoDetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_video_details,parent,false)

        return VideoDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: VideoDetailsViewHolder, position: Int) {
        holder.txtVDTopic.text = itemList[position].topic
        holder.txtVDEarn.text = "You have earned ₹${itemList[position].earn} from this video."
        holder.txtVDStatus.text = "The video is ${itemList[position].Status}."
     }
}