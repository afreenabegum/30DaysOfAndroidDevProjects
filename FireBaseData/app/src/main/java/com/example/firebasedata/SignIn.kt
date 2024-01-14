package com.example.firebasedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.security.Key

class SignIn : AppCompatActivity() {

    lateinit var databaseReference : DatabaseReference

    companion object{
        const val KEY1 = "com.example.firebasedata.SignIn.name"
        const val KEY2 = "com.example.firebasedata.SignIn.id"
        const val KEY3 = "com.example.firebasedata.SignIn.email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signBtn = findViewById<Button>(R.id.btnSignIn)
        val username = findViewById<TextInputEditText>(R.id.btnUniqueId)

        signBtn.setOnClickListener {
            val uniqueId = username.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this,"Please Enter Username !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Users")

            databaseReference.child(uniqueId).get().addOnSuccessListener {
                // checkinh whether user exist or not
                if(it.exists()){
                    // user exist in this case and will display user data
                    val email = it.child("email").value  // it means the email child
                    val name = it.child("name").value
                    val id = it.child("uniqueId").value

                    val intent = Intent(this,WelcomeActivity::class.java)
                    intent.putExtra(KEY1,name.toString())
                    intent.putExtra(KEY2,id.toString())
                    intent.putExtra(KEY3,email.toString())
                    startActivity(intent)

                }else{
                    Toast.makeText(this,"User Does not Exist :( ",Toast.LENGTH_SHORT).show()
                }


            }.addOnFailureListener {
                // this failure event exist if we face any issues while checking with database(app doesn't cope with firebase)
                Toast.makeText(this," Server issue ", Toast.LENGTH_SHORT).show()

            }
    }
}