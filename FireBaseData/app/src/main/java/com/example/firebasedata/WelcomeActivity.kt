package com.example.firebasedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra(SignIn.KEY1)
        val id = intent.getStringExtra(SignIn.KEY2)
        val email = intent.getStringExtra(SignIn.KEY3)

        val welcomeText = findViewById<TextView>(R.id.textViewName)
        val idText = findViewById<TextView>(R.id.textViewId)
        val emailT = findViewById<TextView>(R.id.textViewEmail)

        welcomeText.text= "Welcome $name"
        idText.text = "UserId : $id"
        emailT.text = "Email : $email"

    }
}