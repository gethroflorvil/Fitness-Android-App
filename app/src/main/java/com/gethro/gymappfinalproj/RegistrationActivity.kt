package com.gethro.gymappfinalproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

private val Firebase.firestore: Any
    get() {
        TODO("Not yet implemented")
    }

class RegistrationActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        mAuth = FirebaseAuth.getInstance()

        val button = findViewById<Button>(R.id.signup)
        button.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextText2).text.toString()
            val email = findViewById<EditText>(R.id.editTextTextEmailAddress2).text.toString()
            val password = findViewById<EditText>(R.id.editTextTextPassword2).text.toString()
            val dob = findViewById<EditText>(R.id.editTextDate).text.toString()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        // Add user information to database
                        val db = Firebase.firestore
                        val userInfo = hashMapOf(
                            "name" to name,
                            "email" to email,
                            "dob" to dob
                        )

                        // Go to next screen after successful registration
                        val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
