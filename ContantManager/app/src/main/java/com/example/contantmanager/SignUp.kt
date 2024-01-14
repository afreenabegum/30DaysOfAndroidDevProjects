package com.example.contantmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpBtn = findViewById<Button>(R.id.btnSignUp)
        val signIntext = findViewById<TextView>(R.id.signInLink)

        signUpBtn.setOnClickListener {
            Toast.makeText(this, "You have successfully Registered!!", Toast.LENGTH_SHORT).show()
        }

        signIntext.setOnClickListener {
            val intentSignIn = Intent(this, SignIn::class.java)
            startActivity(intentSignIn)
        }
    }
}