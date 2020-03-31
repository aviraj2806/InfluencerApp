package com.zila.influencerapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.zila.influencerapp.R
import com.zila.influencerapp.adapter.DateAdapter
import com.zila.influencerapp.adapter.MonthAdapter
import com.zila.influencerapp.model.DateData
import com.zila.influencerapp.model.Earnings

class DateDialogFragment(val data: Earnings) : DialogFragment(){
    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: DateAdapter
    val resInfoList = arrayListOf<DateData>()
    val earnList = arrayOf("800","100","950","150","123","135","700","925")
    val nvideoList = arrayOf(5,10,23,32,15,26,20,34)
    lateinit var txtDDBack: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date_dialog, container, false)
        recyclerHome = view.findViewById(R.id.listDate)
        layoutManager = LinearLayoutManager(activity)
        txtDDBack = view.findViewById(R.id.txtDDBack)
        isCancelable = false

        txtDDBack.text = "${data.month} ${data.year} - ${data.earning}"

        txtDDBack.setOnClickListener {
            dismiss()
        }

        for(i in 0 until data.date.size){
            resInfoList.add(DateData("${data.date.get(i)} ${data.month}","${nvideoList.random()} Videos","₹${earnList.random()}"))
        }

        recyclerAdapter = DateAdapter(activity as Context,resInfoList)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager

        return view
    }

}
