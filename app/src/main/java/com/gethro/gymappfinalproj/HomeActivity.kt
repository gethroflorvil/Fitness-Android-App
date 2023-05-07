package com.gethro.gymappfinalproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import java.util.Locale


class HomeActivity : AppCompatActivity() {

    private lateinit var startButton1: Button
    private lateinit var startButton2: Button
    private lateinit var startButton3: Button
    private lateinit var startButton4: Button
    private lateinit var startButton5: Button
    private lateinit var startButton6: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        startButton1 = findViewById(R.id.startButton1)
        startButton2 = findViewById(R.id.startButton2)
        startButton3 = findViewById(R.id.startButton3)
        startButton4 = findViewById(R.id.startButton4)
        startButton5 = findViewById(R.id.startButton5)
        startButton6 = findViewById(R.id.startButton6)

        startButton1.setOnClickListener {
            startTimer(60)
        }

        startButton2.setOnClickListener {
            startTimer(60)
        }

        startButton3.setOnClickListener {
            startTimer(60)
        }

        startButton4.setOnClickListener {
            startTimer(60)
        }

        startButton5.setOnClickListener {
            startTimer(60)
        }

        startButton6.setOnClickListener {
            startTimer(60)
        }
    }

    private fun startTimer(seconds: Long) {
        val intent = Intent(this, TimerActivity::class.java)
        intent.putExtra("timer_seconds", seconds)
        startActivity(intent)
    }

    fun launchQuestionnaire(view: View) {
        val intent = Intent(this, QuestionnaireActivity::class.java)
        startActivity(intent)
    }

    fun launchWorkoutSelection(view: View) {
        val intent = Intent(this, WorkoutSelectionActivity::class.java)
        startActivity(intent)
    }



}

