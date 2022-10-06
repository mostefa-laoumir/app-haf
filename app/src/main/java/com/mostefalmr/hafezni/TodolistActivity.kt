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
import kotlinx.android.synthetic.main.activity_todolist.*
import kotlinx.android.synthetic.main.task_ticket_checked.view.*
import kotlinx.android.synthetic.main.task_ticket_unchecked.view.*
import java.util.*
import kotlin.collections.ArrayList



class TodolistActivity : AppCompatActivity(), QuantityDialog.QuantityDialogListenner {
    var taskTodoList = ArrayList<CheckboxModel>()
    var taskdoneList = ArrayList<CheckboxModel>()
    var adapter: TaskAdapter? = null
    var adapter2: TaskAdapter2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolist)
        add.setOnClickListener{
            openDialog()
        }
        taskTodoList.add(CheckboxModel("GL Exercice 1 et 2"))
        taskTodoList.add(CheckboxModel("SMA TP 3"))
        taskTodoList.add(CheckboxModel("Data Mining Mini Projet"))
        taskTodoList.add(CheckboxModel("GL TP 2"))
        adapter = TaskAdapter(this, taskTodoList)
        tasksList.adapter = adapter
        adapter2 = TaskAdapter2(this, taskdoneList)
        tasksListuncomp.adapter = adapter2

        var mCalendar = Calendar.getInstance()
        val month: String = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
        var d: TextView =findViewById(R.id.d)
        val day =Calendar.DAY_OF_WEEK
        val day1=Calendar.DAY_OF_MONTH

        back.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
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

       /*    im1.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)

        }
        im4.setOnClickListener {
            var intent = Intent(this, Anouncements::class.java)
            finish()
            startActivity(intent)

        }
        im3.setOnClickListener {
            var intent = Intent(this, Contact::class.java)
            finish()
            startActivity(intent)
        }*/
    }
    fun openDialog(){
        var quantityDialog = QuantityDialog()
        quantityDialog.show(supportFragmentManager, "dialog")
    }
    fun delete(index:Int){
        taskTodoList.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
    fun delete2(index:Int){
        taskdoneList.removeAt(index)
        adapter2!!.notifyDataSetChanged()
    }
    inner class TaskAdapter: BaseAdapter {
        var taskLis = ArrayList<CheckboxModel>()
        var context: Context?= null
        constructor(context: Context, Modules: ArrayList<CheckboxModel>):super(){
            this.taskLis=Modules
            this.context = context
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val tsk = taskLis[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            var myView = inflater.inflate(R.layout.task_ticket_unchecked, null)
            myView.Task.text = tsk.text
            myView.uncheck.setOnClickListener {
                taskdoneList.add(tsk)
                delete(position)
                adapter2!!.notifyDataSetChanged()
            }



            return myView
        }

        override fun getItem(position: Int): Any {
            return taskLis[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return taskLis.size
        }

    }
    inner class TaskAdapter2: BaseAdapter {
        var taskLis = ArrayList<CheckboxModel>()
        var context: Context?= null
        constructor(context: Context, Modules: ArrayList<CheckboxModel>):super(){
            this.taskLis=Modules
            this.context = context
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val tsk = taskLis[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            var myView = inflater.inflate(R.layout.task_ticket_checked, null)
            myView.task.text = tsk.text
            myView.check.setOnClickListener {
                delete2(position)
            }



            return myView
        }

        override fun getItem(position: Int): Any {
            return taskLis[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return taskLis.size
        }

    }
    override fun applyText(text:String) {
        if(!text.equals("")){
            taskTodoList.add(CheckboxModel(text))
            adapter!!.notifyDataSetChanged()
        }
    }
}