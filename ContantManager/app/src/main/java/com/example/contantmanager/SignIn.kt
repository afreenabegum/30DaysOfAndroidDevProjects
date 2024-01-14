package com.example.contantmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val SignInBtn= findViewById<Button>(R.id.btnSignIn)
        val uniqueIdtext = findViewById<TextInputEditText>(R.id.uniqueId)

        SignInBtn.setOnClickListener {
            val id = uniqueIdtext.text.toString()
            if(id.isNotEmpty()){
//                 Your Details are found here in DB, then go to contact page
                val intent = Intent(this, contactPage::class.java)
                startActivity(intent)
            }else{
//                 Please SignUp !!
                Toast.makeText(this, "Please Go Back and SignUp !! ", Toast.LENGTH_SHORT).show()
            }

        }
    }
}