package com.zila.influencerapp.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.zila.influencerapp.R
import com.zila.influencerapp.activity.DashboardActivity
import com.zila.influencerapp.activity.LoginActivity
import com.zila.influencerapp.adapter.YearAdapter
import com.zila.influencerapp.model.YearData

class ProfileFragment : Fragment(),YearAdapter.YearListener {

    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: YearAdapter
    val resInfoList = arrayListOf<YearData>()
    lateinit var monthFrameLayout: FrameLayout
    lateinit var llProfile: LinearLayout
    lateinit var llEarning: LinearLayout
    lateinit var txtEarnExpand: TextView
    lateinit var txtUserProfile: TextView
    lateinit var imgLogOut: ImageView
    lateinit var imgEdit: ImageView
    var expand = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        recyclerHome = view.findViewById(R.id.listYear)
        layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        monthFrameLayout = view.findViewById(R.id.monthFrameLayout)
        llEarning = view.findViewById(R.id.llEarning)
        llProfile = view.findViewById(R.id.llProfile)
        txtEarnExpand = view.findViewById(R.id.txtEarnExpand)
        txtUserProfile = view.findViewById(R.id.txtUserProfile)
        imgLogOut = view.findViewById(R.id.imgLogOut)
        imgEdit = view.findViewById(R.id.imgEdit)
        llProfile.visibility = View.GONE
        llEarning.visibility = View.GONE

        llProfile.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_up_in))
        llProfile.visibility = View.VISIBLE
        llEarning.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_up_in))
        llEarning.visibility = View.VISIBLE

        setupYear(2019)

        resInfoList.add(YearData(2019,true))
        resInfoList.add(YearData(2018,false))
        resInfoList.add(YearData(2017,false))
        resInfoList.add(YearData(2016,false))
        resInfoList.add(YearData(2015,false))
        resInfoList.add(YearData(2014,false))
        resInfoList.add(YearData(2013,false))
        resInfoList.add(YearData(2012,false))
        resInfoList.add(YearData(2011,false))
        resInfoList.add(YearData(2010,false))


        recyclerAdapter = YearAdapter(activity as Context,resInfoList,this)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager

        txtEarnExpand.setOnClickListener {
            if(expand){
                llProfile.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_down_in))
                llEarning.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.down))
                llProfile.visibility = View.VISIBLE
                txtEarnExpand.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_up,0)
                expand = false
            }else{
                llEarning.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_up_in))
                llProfile.startAnimation(AnimationUtils.loadAnimation(activity,R.anim.push_right_out))
                llProfile.visibility = View.GONE
                txtEarnExpand.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_down,0)
                expand = true
            }
        }

        imgLogOut.setOnClickListener {
            val intent = Intent(activity,LoginActivity::class.java)
            startActivity(intent)
            activity!!.finish()
        }

        imgEdit.setOnClickListener {
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

    override fun onYearDataListener(yearData: YearData) {
        Log.d("hello","year : "+yearData.year)
        setupYear(yearData.year)
    }

    fun setupYear(year: Int){
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.monthFrameLayout,MonthFragment(year)).commit()
    }

}
