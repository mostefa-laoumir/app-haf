package com.mostefalmr.hafezni

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.module_ticket.*
import kotlinx.android.synthetic.main.module_ticket.view.*


class MainActivity : AppCompatActivity() {
    var moduleList = ArrayList<ModuleModel>()
    var adapter:ModuleAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleList.add(ModuleModel("Engeneering",14.0))
        moduleList.add(ModuleModel("Engeneering",50.0))
        moduleList.add(ModuleModel("Engeneering",92.0))
        adapter = ModuleAdapter(this, moduleList)
        modulesList.adapter = adapter




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
                myView.percentageID.text = module.percentage.toString()+"%"
                if(module.percentage!!<50.0){
                    myView.moduleRankImage.setImageResource(R.drawable.redmotiv)
                }else if(module.percentage!!<85.0){
                    myView.moduleRankImage.setImageResource(R.drawable.yellowmotiv)
                    myView.percentageID.setTextColor(ContextCompat.getColor(context!!, R.color.hafezni_Gold))

                }else{
                    myView.moduleRankImage.setImageResource(R.drawable.tealmotiv)
                    myView.percentageID.setTextColor(ContextCompat.getColor(context!!, R.color.hafezni_Teal))

                }


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