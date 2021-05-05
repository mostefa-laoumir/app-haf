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
            if(editTextTextPersonName.text.toString()=="" && editTextTextPassword.text.toString()==""){
                var intent = Intent(this, ReasonForStudyActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }
}