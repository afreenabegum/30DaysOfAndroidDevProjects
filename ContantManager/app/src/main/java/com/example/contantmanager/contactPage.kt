package com.example.contantmanager

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class contactPage : AppCompatActivity() {

    lateinit var database : DatabaseReference
    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_page)

        val ButtonAdd = findViewById<Button>(R.id.btnAdd)
        val ButtonName = findViewById<TextInputEditText>(R.id.contactName)
        val ButtonEmail = findViewById<TextInputEditText>(R.id.contactEmail)
        val ButtonPhone = findViewById<TextInputEditText>(R.id.contactPhone)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.customdialogbox)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.customdialogbg))

        ButtonAdd.setOnClickListener {
            val name = ButtonName.text.toString()
            val email = ButtonEmail.text.toString()
            val phoneNo = ButtonPhone.text.toString()

            val user = User(name,email,phoneNo)
            database = FirebaseDatabase.getInstance().getReference("ContactList")

            database.child(phoneNo).setValue(user).addOnSuccessListener {
                // clearing fields
                ButtonName.text?.clear()
                ButtonEmail.text?.clear()
                ButtonPhone.text?.clear()
//                dialog.show()
                Toast.makeText(this,"Contact Saved Successfully !", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Saving Failed!", Toast.LENGTH_SHORT).show()
            }

            dialog.show()

        }

    }
}