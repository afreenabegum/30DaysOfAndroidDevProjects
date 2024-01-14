package com.example.viewbinding

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.button.setOnClickListener {
           if(binding.checkBox.isChecked){
               val intent = Intent(this, WelcomePage::class.java)
               startActivity(intent)
           }else{
               binding.checkBox.backgroundTintList = ColorStateList.valueOf(Color.RED)
               Toast.makeText(this,"Please Accept Terms & Conditions !", Toast.LENGTH_SHORT).show()
           }
       }
    }
}