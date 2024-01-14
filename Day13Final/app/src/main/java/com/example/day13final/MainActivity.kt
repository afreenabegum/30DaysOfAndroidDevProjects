package com.example.day13final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.activity_main.btnOrder
//import kotlinx.android.synthetic.main.activity_main.editText1
//import kotlinx.android.synthetic.main.activity_main.editText2
//import kotlinx.android.synthetic.main.activity_main.editText3
//import kotlinx.android.synthetic.main.activity_main.editText4

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY = "com.example.day13final.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOrder.setOnClickListener {
            val orderList = editText1.text.toString() + " " + editText2.text.toString() +
                    " " + editText3.text.toString() + " " + editText4.text.toString()

            intent = Intent(this,order::class.java)
            intent.putExtra(KEY,orderList)
            startActivity(intent)
        }
    }
}