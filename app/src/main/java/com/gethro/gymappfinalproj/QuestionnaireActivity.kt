package com.gethro.gymappfinalproj

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner

class QuestionnaireActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            saveAnswers()
            navigateToHome()
        }
    }

    private fun saveAnswers() {
        val goalRadioGroup = findViewById<RadioGroup>(R.id.goalRadioGroup)
        val selectedGoal = findViewById<RadioButton>(goalRadioGroup.checkedRadioButtonId)
        val goalValue = selectedGoal.text.toString()

        val timeSpinner = findViewById<Spinner>(R.id.timeSpinner)
        val timeValue = timeSpinner.selectedItem.toString()

        val editor = preferences.edit()
        editor.putString("goal", goalValue)
        editor.putString("time", timeValue)
        editor.apply()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
