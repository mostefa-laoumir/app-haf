package com.mostefalmr.hafezni


import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDialogFragment
import kotlinx.android.synthetic.main.task_input.*
import java.lang.ClassCastException
import java.util.zip.Inflater

class QuantityDialog : AppCompatDialogFragment() {
    lateinit var listenner:QuantityDialogListenner
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(activity)
        var inflater: LayoutInflater = activity!!.layoutInflater
        var view: View = inflater.inflate(R.layout.task_input, null)
        val qnt:EditText = view.findViewById(R.id.editCount)
        builder.setView(view).setTitle("New Task").setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

        }).setPositiveButton("Ok", DialogInterface.OnClickListener{dialogInterface, i ->
            listenner.applyText(qnt.editableText.toString())
        })


        return builder.create()
    }

    override fun onAttach(context:Context) {
        super.onAttach(context)
        try {
            listenner = context as QuantityDialogListenner
        } catch (e: Exception) {
        }
    }

    public interface QuantityDialogListenner{
        fun applyText(quantity : String)
    }
}