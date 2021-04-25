package com.mostefalmr.hafezni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button.setOnClickListener{
            if(editTextTextPersonName.text.toString()=="998877" && editTextTextPassword.text.toString()=="123"){
                var intent = Intent(this, Mood::class.java)
                finish()
                startActivity(intent)
            }
        }
    }
}