package com.mostefalmr.hafezni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_schedule.*

class Schedule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        im1.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)

        }
        im4.setOnClickListener {
            var intent = Intent(this,Anouncements::class.java)
            finish()
            startActivity(intent)

        }
        im3.setOnClickListener {
            var intent = Intent(this,Contact::class.java)
            finish()
            startActivity(intent)
        }
    }
}