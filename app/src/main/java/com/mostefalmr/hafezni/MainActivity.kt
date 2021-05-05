package com.mostefalmr.hafezni

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.module_ticket.*
import kotlinx.android.synthetic.main.module_ticket.view.*


class MainActivity : AppCompatActivity() {
    var moduleList = ArrayList<ModuleModel>()
    var adapter:ModuleAdapter?=null
    var average2 = ArrayList<ModuleModel>()
    var adapter2:ModuleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var img: ImageView = findViewById(R.id.imageView5)
        getPermission()
        nameID.setOnClickListener(object : View.OnClickListener {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onClick(v: View?) {
                if (!Settings.canDrawOverlays(this@MainActivity)) {
                    getPermission()
                } else {
                    val intent = Intent(this@MainActivity, WidgetService::class.java)
                    startService(intent)
                    finish()
                }
            }
        })
        moduleList.add(ModuleModel("Software Engeneering", 14.0))
        moduleList.add(ModuleModel("Admin BDD", 50.0))
        moduleList.add(ModuleModel("Reseaux et Telecom", 92.0))
        adapter = ModuleAdapter(this, moduleList)
        modulesList.adapter = adapter
        average2.add(ModuleModel("Average", 70.0))
        adapter2= ModuleAdapter(this, average2)
        averageList.adapter = adapter2

        im2.setOnClickListener {
            var intent = Intent(this, Schedule::class.java)
            finish()
            startActivity(intent)

        }
        im4.setOnClickListener {
            var intent = Intent(this, TodolistActivity::class.java)
            finish()
            startActivity(intent)

        }
        im3.setOnClickListener {
            var intent = Intent(this, Contact::class.java)
            finish()
            startActivity(intent)

        }
        im99.setOnClickListener {
            var intent = Intent(this, Challenge::class.java)
            finish()
            startActivity(intent)
        }
        img.setOnClickListener {
            var intent = Intent(this, Anouncements::class.java)
            finish()
            startActivity(intent)
        }

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
            val module = moduleLis[position]
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

                    myView.percentageID.setTextColor(ContextCompat.getColor(context!!, R.color.hafezni_Gold))



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


    fun getPermission(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)){
                var intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()))
                startActivityForResult(intent, 1)

        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(!Settings.canDrawOverlays(this@MainActivity)){
                Toast.makeText(this, "Permission denied by user!", Toast.LENGTH_LONG).show()

            }
        }
    }

}