package com.example.firebasedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSignUp = findViewById<Button>(R.id.btnSignUp)
        val textName = findViewById<TextInputEditText>(R.id.btnName)
        val textMail = findViewById<TextInputEditText>(R.id.btnMail)
        val textPassword = findViewById<TextInputEditText>(R.id.btnPassword)
        val textUniqueId = findViewById<TextInputEditText>(R.id.btnUniqueId)

        buttonSignUp.setOnClickListener {
            val name = textName.text.toString()
            val email = textMail.text.toString()
            val password = textPassword.text.toString()
            val uniqueId = textUniqueId.text.toString()


            val user = User(name,email,password,uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")


            database.child(uniqueId).setValue(user).addOnSuccessListener {
                textName.text?.clear()
                textMail.text?.clear()
                textPassword.text?.clear()
                textUniqueId.text?.clear()
                Toast.makeText(this, "Registration Successful !", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Registration Failed !", Toast.LENGTH_SHORT).show()

            }

        }

        val signInBtn = findViewById<TextView>(R.id.textViewSignIn)
        signInBtn.setOnClickListener {
            val openIntent = Intent(this, SignIn::class.java)
            startActivity(openIntent)
        }

    }
}