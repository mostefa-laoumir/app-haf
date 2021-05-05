package com.mostefalmr.hafezni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rank.*

class RankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)
        backButton.setOnClickListener {
            var intent = Intent(this, Challenge::class.java)
            finish()
            startActivity(intent)
        }

    }
}