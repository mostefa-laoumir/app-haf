package com.mostefalmr.hafezni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_challenge.*

class Challenge : AppCompatActivity() {
    var i = 0
    var questions=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge)
        questions.add("Is the Sky Red?\n True? or False?")
        questions.add("Dolphins are Mammals?\n True? or False?")
        questions.add("Whales sing to Communicate?\n True? or False?")
        questions.add("CO is not a dangerous for your lungs?\n True? or False?")
        questions.add("Is H2O the chemical formula of water?\n" +
                " True? or False?")



        backImage.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
        trueImage.setOnClickListener {
                quizQuestion.text = questions.get(i)
            i = (i+1)%5
        }
        scoreImage.setOnClickListener {
            var intent = Intent(this, RankActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}