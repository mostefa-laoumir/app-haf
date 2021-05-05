package com.mostefalmr.hafezni

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reason_for_study.*

class ReasonForStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reason_for_study)
        tv1.setOnClickListener {
            tv1.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv1.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv2.setOnClickListener {
            tv2.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv2.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv3.setOnClickListener {
            tv3.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv3.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv5.setOnClickListener {
            tv5.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv5.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv6.setOnClickListener {
            tv6.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv6.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv7.setOnClickListener {
            tv7.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv7.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv8.setOnClickListener {
            tv8.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv8.setTextColor(Color.parseColor("#FFFFFF"))
        }
        tv9.setOnClickListener {
            tv9.setBackgroundColor(ContextCompat.getColor(this, R.color.hafezni_Teal))
            tv9.setTextColor(Color.parseColor("#FFFFFF"))
        }

        addbtn.setOnClickListener {
            var intent = Intent(this,Mood::class.java )
            finish()
            startActivity(intent)
        }
    }
}