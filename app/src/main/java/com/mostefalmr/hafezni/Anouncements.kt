package com.mostefalmr.hafezni

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_anouncements.*
import kotlinx.android.synthetic.main.annoucement_ticket_attention.view.*
import kotlinx.android.synthetic.main.announcement_ticket_congrats.view.*
import kotlinx.android.synthetic.main.announcement_ticket_congrats.view.nameID
import kotlinx.android.synthetic.main.announcement_ticket_motivation.view.*
import kotlinx.android.synthetic.main.reciever_ticket.view.*
import kotlinx.android.synthetic.main.sender_ticket.view.*

class Anouncements : AppCompatActivity() {
    var announcmentList = ArrayList<AnnouncementModel>()
    var adapter:AnnouncementAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anouncements)


        announcmentList.add(AnnouncementModel("Abdelhakim",resources.getString(R.string.congrats_text),resources.getString(R.string.congrats_link),1))
        announcmentList.add(AnnouncementModel("Abdelhakim",resources.getString(R.string.motivation_text),"",2))
        announcmentList.add(AnnouncementModel("Abdelhakim",resources.getString(R.string.attention_text),resources.getString(R.string.attention_link),3))
        announcmentList.add(AnnouncementModel("Abdelhakim",resources.getString(R.string.motivation_text),"",2))

        adapter = AnnouncementAdapter(this, announcmentList)
        announcmentsListView.adapter = adapter


        var intent:Intent
        backk.setOnClickListener {
             intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)

        }






    }

    inner class AnnouncementAdapter: BaseAdapter {
        var announcmentLis = ArrayList<AnnouncementModel>()
        var context: Context?= null
        constructor(context: Context, Modules: ArrayList<AnnouncementModel>):super(){
            this.announcmentLis=Modules
            this.context = context
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val ancmnt = announcmentLis[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if(ancmnt.type==1){
                var myView = inflater.inflate(R.layout.announcement_ticket_congrats, null)
                myView.congratsText.text = ancmnt.text
                myView.congratsLink.text = ancmnt.link
                myView.nameID.text = "Hi "+ancmnt.name+"!"

                return myView
            }else if(ancmnt.type==2){
                var myView = inflater.inflate(R.layout.announcement_ticket_motivation, null)
                myView.motivText.text = ancmnt.text
                myView.nameID.text = "Hi "+ancmnt.name+"!"

                return myView
            }else{
                var myView = inflater.inflate(R.layout.annoucement_ticket_attention, null)
                myView.attentionText.text = ancmnt.text
                myView.attentionLink.text = ancmnt.link
                myView.nameIDa.text = "Hi "+ancmnt.name+"!"

                return myView
            }


        }

        override fun getItem(position: Int): Any {
            return announcmentLis[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return announcmentLis.size
        }

    }
}