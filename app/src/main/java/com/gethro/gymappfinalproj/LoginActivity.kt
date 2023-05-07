package com.gethro.gymappfinalproj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private fun signIn(email: String, password: String) {
        val mAuth = FirebaseAuth.getInstance()

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = mAuth.currentUser
                    //Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, QuestionnaireActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
       val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
       val loginButton = findViewById<Button>(R.id.login_button)

       loginButton.setOnClickListener {
           val email = emailEditText.text.toString()
           val password = passwordEditText.text.toString()

           if (email.isNotEmpty() && password.isNotEmpty()) {
               signIn(email, password)
           } else {
               Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
           }
       }

        val registerTextView = findViewById<TextView>(R.id.register_textview)
        registerTextView.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}

