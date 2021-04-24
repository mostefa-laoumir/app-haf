package com.mostefalmr.hafezni

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.module_ticket.*
import kotlinx.android.synthetic.main.module_ticket.view.*


class MainActivity : AppCompatActivity() {
    var moduleList = ArrayList<ModuleModel>()
    var adapter:ModuleAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moduleList.add(ModuleModel("Software Engeneering", 14.0))
        moduleList.add(ModuleModel("Admin BDD", 50.0))
        moduleList.add(ModuleModel("Reseaux et Telecom", 92.0))
        adapter = ModuleAdapter(this, moduleList)
        modulesList.adapter = adapter




    }

    inner class ModuleAdapter: BaseAdapter {
        var moduleLis = ArrayList<ModuleModel>()
        var context: Context?= null
        constructor(context: Context, Modules: ArrayList<ModuleModel>):super(){
            this.moduleLis=Modules
            this.context = context
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val module = moduleList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var myView = inflater.inflate(R.layout.module_ticket, null)
                myView.moduleID.text = module.name!!
                myView.percentageID.text = module.percentage.toString()+"%"

                if(module.percentage!!<50.0){
                    myView.moduleRankImage.setImageResource(R.drawable.redmotiv)
                    myView.pbID.getProgressDrawable().setColorFilter(Color.parseColor("#FF575F"), PorterDuff.Mode.SRC_IN);

                }else if(module.percentage!!<85.0){
                    myView.moduleRankImage.setImageResource(R.drawable.yellowmotiv)
                    myView.pbID.getProgressDrawable().setColorFilter(Color.parseColor("#FFC542"), PorterDuff.Mode.SRC_IN);

                    myView.percentageID.setTextColor(ContextCompat.getColor(context!!,R.color.hafezni_Gold))



                }else{
                    myView.moduleRankImage.setImageResource(R.drawable.tealmotiv)
                    myView.percentageID.setTextColor(ContextCompat.getColor(context!!, R.color.hafezni_Teal))

                }
            myView.pbID.setProgress(module.percentage!!.toInt(), true)



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