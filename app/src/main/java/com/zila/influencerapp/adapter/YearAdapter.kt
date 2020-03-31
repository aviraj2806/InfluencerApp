package com.zila.influencerapp.adapter

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zila.influencerapp.R
import com.zila.influencerapp.model.YearData

class YearAdapter(val context: Context,val itemList:ArrayList<YearData>,val yearListener: YearListener) : RecyclerView.Adapter<YearAdapter.YearViewHolder>(){

    var pre = -1

    class YearViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val txtYear: TextView = view.findViewById(R.id.txtYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearAdapter.YearViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_year, parent, false)

        return YearViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: YearAdapter.YearViewHolder, position: Int) {
        val year = itemList[position].year
        val click = itemList[position].clicked

        holder.txtYear.text = year.toString()
        if(click) {
            holder.txtYear.setTextColor(context.resources.getColor(R.color.colorPrimary))
            holder.txtYear.background = context.resources.getDrawable(R.drawable.curved_input)
            pre = position
        }else{
            holder.txtYear.setTextColor(context.resources.getColor(R.color.notSelected))
            holder.txtYear.background = null
        }

        holder.txtYear.setOnClickListener {
            if(pre != position) {
                itemList[position].clicked = true
                if (pre != -1) {
                    itemList[pre].clicked = false
                    yearListener.onYearDataListener(itemList[position])
                    notifyDataSetChanged()
                }
            }
        }
    }

    interface YearListener {
        fun onYearDataListener(yearData: YearData)
    }
}