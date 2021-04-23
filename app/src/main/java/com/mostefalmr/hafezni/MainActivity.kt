package com.mostefalmr.hafezni

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.module_ticket.view.*


class MainActivity : AppCompatActivity() {
    var moduleList = ArrayList<ModuleModel>()
    var adapter:ModuleAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleList.add(ModuleModel("Engeneering",14.0))


    }

    inner class ModuleAdapter: BaseAdapter {
        var moduleLis = ArrayList<ModuleModel>()
        var context: Context?= null
        constructor(context: Context, Modules :ArrayList<ModuleModel>):super(){
            this.moduleLis=Modules
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val module = moduleList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var myView = inflater.inflate(R.layout.module_ticket, null)
                myView.moduleID.text = module.name!!
                myView.percentageID.text = module.percentage.toString()

                return myView




        }

        override fun getItem(position: Int): Any {
            return moduleLis[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return moduleLis.size
        }

    }

}