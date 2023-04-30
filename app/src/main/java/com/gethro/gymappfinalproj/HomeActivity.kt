package com.gethro.gymappfinalproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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

