package com.zila.influencerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zila.influencerapp.R
import com.zila.influencerapp.model.DateData

class DateAdapter(val context: Context,val itemList: ArrayList<DateData>) :RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    class DateViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val date: TextView = view.findViewById(R.id.ldDate)
        val nvideo: TextView = view.findViewById(R.id.ldNvideo)
        val earn: TextView = view.findViewById(R.id.ldEarn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_date,parent,false)

        return DateViewHolder(view)
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val date = itemList[position].date
        val earn = itemList[position].earn
        val nvideo = itemList[position].nvideo

        holder.date.text = date
        holder.earn.text = earn
        holder.nvideo.text = nvideo
    }
}