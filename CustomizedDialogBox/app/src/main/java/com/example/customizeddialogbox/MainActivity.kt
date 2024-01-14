package com.example.customizeddialogbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
     lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogbox)
        // setting background of customized Alert DialogBox
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_customdialog))

        var BtnGood = dialog.findViewById<Button>(R.id.GoodBtn)
        var Btnfeedback = dialog.findViewById<Button>(R.id.feedbackBtn)
        var mainClick = findViewById<Button>(R.id.btnClickMe)

        BtnGood.setOnClickListener {
            Toast.makeText(this, "Keep Going !!",Toast.LENGTH_SHORT).show()
        }
        Btnfeedback.setOnClickListener {
            Toast.makeText(this, "We will reach out to you in short !",Toast.LENGTH_SHORT).show()
        }

        mainClick.setOnClickListener {
            dialog.show()
        }

    }
}