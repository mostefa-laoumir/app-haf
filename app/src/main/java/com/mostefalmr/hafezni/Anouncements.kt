package com.mostefalmr.hafezni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_anouncements.*

class Anouncements : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anouncements)
        var intent:Intent
        im1.setOnClickListener {
             intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        im2.setOnClickListener {
             intent = Intent(this,Schedule::class.java)
            startActivity(intent)

        }
        im3.setOnClickListener {
            intent = Intent(this,Contact::class.java)
            startActivity(intent)

        }
    }
}