package com.mostefalmr.hafezni

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_contact.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.module_ticket.view.*
import kotlinx.android.synthetic.main.reciever_ticket.view.*
import kotlinx.android.synthetic.main.sender_ticket.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import kotlin.collections.ArrayList


class Contact : AppCompatActivity() {
    var messagesList = ArrayList<Message>()
    var adapter: MessageAdapter?=null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        adapter = MessageAdapter(this, messagesList)
        MessagesListView.adapter = adapter
        messageID.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                messagesList.add(
                    Message(
                        "Abdelhakim",
                        LocalDateTime.now()
                            .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
                        messageID.text.toString()
                    )
                )
                messagesList.add(
                    Message(
                        "Admin",
                        LocalDateTime.now()
                            .format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
                        "thank you for reaching us, an admin will contact you soon..."
                    )
                )
                adapter!!.notifyDataSetChanged()

                return@OnKeyListener true
            }
            false
        })

    }

    inner class MessageAdapter: BaseAdapter {
        var messagesLis = ArrayList<Message>()
        var context: Context?= null
        constructor(context: Context, Modules: ArrayList<Message>):super(){
            this.messagesLis=Modules
            this.context = context
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val msg = messagesLis[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if(msg.owner=="Admin"){
                var myView = inflater.inflate(R.layout.reciever_ticket, null)
                myView.messageIDReciever.text = msg.message
                myView.ownerIDRecieve.text = msg.owner
                myView.timeIDRecieve.text = msg.time


                return myView

            }else{

                var myView = inflater.inflate(R.layout.sender_ticket, null)
                myView.messageIDSend.text = msg.message
                myView.ownerIDSend.text = msg.owner
                myView.timeIDSend.text = msg.time




                return myView
            }


        }

        override fun getItem(position: Int): Any {
            return messagesLis[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return messagesLis.size
        }

    }

}