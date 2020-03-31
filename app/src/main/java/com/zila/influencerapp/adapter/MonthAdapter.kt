package com.zila.influencerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zila.influencerapp.R
import com.zila.influencerapp.model.Earnings

class MonthAdapter(val context: Context, val itemList:ArrayList<Earnings>,val monthListener: MonthListener) : RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    class MonthViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val month: TextView = view.findViewById(R.id.month)
        val mearn: TextView = view.findViewById(R.id.mearn)
        val nvideo: TextView = view.findViewById(R.id.nvideos)
        val rlMonthDetails: RelativeLayout = view.findViewById(R.id.rlMonthDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_month, parent, false)


        return MonthViewHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        val month = itemList[position].month
        val mearn = itemList[position].earning
        val nvideo = itemList[position].nvideo

        holder.month.text = month
        holder.nvideo.text = "$nvideo Videos"
        holder.mearn.text = "₹ $mearn"

        holder.rlMonthDetails.setOnClickListener {
            monthListener.onMonthListener(itemList[position])
        }

    }

    interface MonthListener{
        fun onMonthListener(earnings: Earnings)
    }
}