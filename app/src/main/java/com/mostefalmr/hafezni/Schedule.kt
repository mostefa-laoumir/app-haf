package com.mostefalmr.hafezni

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.course_ticket.view.*
import kotlinx.android.synthetic.main.reciever_ticket.view.*
import kotlinx.android.synthetic.main.sender_ticket.view.*
import java.util.*
import kotlin.collections.ArrayList

class Schedule : AppCompatActivity() {
       var coursesList = ArrayList<CourseModel>()
       var adapter: CourseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        coursesList.add(CourseModel("Software Engeneering", "11:00", "12:30", "Theatre C"))
        coursesList.add(CourseModel("Data Mining", "14:00", "15:30", "Theatre A"))
        coursesList.add(CourseModel("Reseaux et Telecom", "15:30", "17:00", "Room 6"))
        coursesList.add(CourseModel("SMA", "15:30", "17:00", "Room 6"))
        adapter = CourseAdapter(this, coursesList)
        coursesListView.adapter = adapter
       var mCalendar = Calendar.getInstance()
        val month: String = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
        var d:TextView=findViewById(R.id.d)
        val day =Calendar.DAY_OF_WEEK
        val day1=Calendar.DAY_OF_MONTH

        d.text = day.toString()
        textView13.text = "$month $day"
        if(day==1){
            mm.background = getResources().getDrawable(R.drawable.callendar_day_bg);
            m.setTextColor(Color.WHITE)
            textView12.text = "Mon"
            d2.text = day1.toString()
            d3.text = ((day1+1)%30).toString()
            d4.text = ((day1+2)%30).toString()
            d5.text = ((day1+3)%30).toString()
            d1.text = ((day1-1)%30).toString()

        }else if(day == 2){
            ttu.background = getResources().getDrawable(R.drawable.callendar_day_bg);
            tu.setTextColor(Color.WHITE)
            textView12.text = "Tue"
            d2.text = ((day1-1)%30).toString()
            d3.text = day1.toString()
            d4.text = ((day1+1)%30).toString()
            d5.text = ((day1+2)%30).toString()
            d1.text = ((day1-2)%30).toString()

        }else if(day == 3){
            ww.background = getResources().getDrawable(R.drawable.callendar_day_bg);
            w.setTextColor(Color.WHITE)
            textView12.text = "Wed"
            d2.text = ((day1-2)%30).toString()
            d3.text = ((day1-1)%30).toString()
            d4.text = day1.toString()
            d5.text = ((day1+1)%30).toString()
            d1.text = ((day1-3)%30).toString()

        }else if(day == 4){
            tth.background = getResources().getDrawable(R.drawable.callendar_day_bg);
            th.setTextColor(Color.WHITE)
            textView12.text = "Thu"
            d2.text = ((day1-3)%30).toString()
            d3.text = ((day1-2)%30).toString()
            d4.text = ((day1-1)%30).toString()
            d5.text = day1.toString()
            d1.text = ((day1-4)%30).toString()

        }else if(day == 7){
            ss.background = getResources().getDrawable(R.drawable.callendar_day_bg);
            s.setTextColor(Color.WHITE)
            textView12.text = "Sun"
            d2.text = ((day1+1)%30).toString()
            d3.text = ((day1+2)%30).toString()
            d4.text = ((day1+3)%30).toString()
            d5.text = ((day1+4)%30).toString()
            d1.text = day1.toString()
        }

        im1.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)

        }
        im4.setOnClickListener {
            var intent = Intent(this, TodolistActivity::class.java)
            finish()
            startActivity(intent)

        }
        im3.setOnClickListener {
            var intent = Intent(this, Challenge::class.java)
            finish()
            startActivity(intent)
        }
    }


    inner class CourseAdapter: BaseAdapter {
        var courseLis = ArrayList<CourseModel>()
        var context: Context?= null
        constructor(context: Context, Modules: ArrayList<CourseModel>):super(){
            this.courseLis=Modules
            this.context = context
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val crs = courseLis[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var myView = inflater.inflate(R.layout.course_ticket, null)
                myView.courseID.text = crs.name
                myView.timeStart.text = crs.startingHour
                myView.timeEnd.text = crs.endingHour
                myView.ClassroomID.text = crs.room


                return myView
        }

        override fun getItem(position: Int): Any {
            return courseLis[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return courseLis.size
        }

    }
}