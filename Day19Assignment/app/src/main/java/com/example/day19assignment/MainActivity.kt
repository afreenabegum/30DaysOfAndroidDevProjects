package com.example.day19assignment

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.day19assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.que1.setOnClickListener {
            val array = arrayOf("Android Development", "Web Development", "IOS Development")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Domain you are Interested in ?")
            builder.setSingleChoiceItems(array,0,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"You have selected ${array[which]}",Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Answer Submitted",Toast.LENGTH_SHORT).show()
            })
            builder.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Declined !",Toast.LENGTH_SHORT).show()
            })
            builder.show()
        }

        binding.que2.setOnClickListener {
            val array = arrayOf("onCreate", "onDestroy","onPause","onResume")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select the methods included in Activity Lifecycle in Android Dev?")
           builder.setMultiChoiceItems(array,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
//               Toast.makeText(this,"You have selected ${array[which]}",Toast.LENGTH_SHORT).show()
           })
            builder.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Answer Submitted",Toast.LENGTH_SHORT).show()
            })
            builder.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Answer not Submitted",Toast.LENGTH_SHORT).show()
            })
            builder.show()
        }

        binding.que3.setOnClickListener {
            val array = arrayOf("Courses", "YouTube Videos")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which one do you follow more?")
            builder.setMultiChoiceItems(array,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You have selected ${array[which]}",Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Response Recorded",Toast.LENGTH_SHORT).show()
            })
            builder.setNegativeButton("Declined",DialogInterface.OnClickListener { dialog, which ->

            })
            builder.show()
        }

        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are you Sure ?")
            builder.setMessage("You want to exit")
            builder.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                finish()
            })
            builder.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            builder.show()
        }
    }
}