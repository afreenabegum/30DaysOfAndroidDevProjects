package com.example.day13final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order.textViewOrder

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val customerOrder = intent.getStringExtra(MainActivity.KEY)

        textViewOrder.text = "Order Placed " + customerOrder.toString()
    }
}