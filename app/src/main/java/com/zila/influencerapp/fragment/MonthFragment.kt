package com.zila.influencerapp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.zila.influencerapp.R
import com.zila.influencerapp.adapter.MonthAdapter
import com.zila.influencerapp.adapter.YearAdapter
import com.zila.influencerapp.model.Earnings
import com.zila.influencerapp.model.YearData

class MonthFragment(val year:Int) : Fragment(),MonthAdapter.MonthListener {
    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: MonthAdapter
    val resInfoList = arrayListOf<Earnings>()
    val dateList30 = arrayListOf<String>()
    val dateList31 = arrayListOf<String>()
    val dateList29 = arrayListOf<String>()
    val nvideo = arrayOf(45,35,40,55,60,80,100,95)
    val earn = arrayOf("8000","10000","9500","15000","12350","13500","7000","9250")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_month, container, false)
        recyclerHome = view.findViewById(R.id.listMonth)
        layoutManager = LinearLayoutManager(activity)
        for(i in 1..30){
            dateList30.add(i.toString())
        }
        for(i in 1..31){
            dateList31.add(i.toString())
        }
        for(i in 1..29){
            dateList29.add(i.toString())
        }
        resInfoList.add(Earnings(year,"January",dateList31,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"February",dateList29,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"March",dateList31,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"April",dateList30,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"May",dateList31,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"June",dateList30,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"July",dateList31,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"August",dateList31,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"September",dateList30,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"October",dateList31,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"November",dateList30,nvideo.random(),earn.random()))
        resInfoList.add(Earnings(year,"December",dateList31,nvideo.random(),earn.random()))

        recyclerAdapter = MonthAdapter(activity as Context,resInfoList,this)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager

        return view
    }

    override fun onMonthListener(earnings: Earnings) {
        val dialog: DateDialogFragment = DateDialogFragment(earnings)
        dialog.show(activity!!.supportFragmentManager,"DateDialog")
    }

}
