package com.mostefalmr.hafezni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mood.*

class Mood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)
        var intent = Intent(this, MainActivity::class.java)
        imageView2.setOnClickListener {
            finish()
            startActivity(intent)
        }
        imageView3.setOnClickListener {
            finish()
            startActivity(intent)
        }
        imageView4.setOnClickListener {
            finish()
            startActivity(intent)
        }
        imageView6.setOnClickListener {
            finish()
            startActivity(intent)
        }
        imageView7.setOnClickListener {
            finish()
            startActivity(intent)
        }
        imageView8.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }
}