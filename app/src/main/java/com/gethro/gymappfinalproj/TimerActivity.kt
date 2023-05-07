package com.gethro.gymappfinalproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.Locale


class TimerActivity : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        timerTextView = findViewById(R.id.timer_text_view)

        val seconds = intent.getLongExtra("timer_seconds", 60)

        timer = object : CountDownTimer(seconds * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
                timerTextView.text = timeLeftFormatted
            }

            override fun onFinish() {
                timerTextView.text = "Nice job!"
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}