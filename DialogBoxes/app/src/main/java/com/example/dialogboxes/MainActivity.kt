package com.example.dialogboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure ?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setMessage("Do you want to Exit")
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                // write code, which action you want to perform, when you click Yes
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                // write code, which action you want to perform, when you click No
            })
            builder1.show()
        }

        binding.button2.setOnClickListener {
            val arrayLanguage = arrayOf("Kotlin"," Java", "Python")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your Favourite Language?")
            builder2.setIcon(R.drawable.baseline_code_24)
            builder2.setSingleChoiceItems(arrayLanguage,0,DialogInterface.OnClickListener { dialog, which ->
                // write the code, which action you want to perform, when you selecting any option
                Toast.makeText(this,"You have selected ${arrayLanguage[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Accept",DialogInterface.OnClickListener { dialog, which ->
                // write the code, which action you want to perform, after selecting / performing above action
                Toast.makeText(this,"Response Received !!", Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }

            binding.button3.setOnClickListener {
                val array = arrayOf("1","2","3")
                val builder3 = AlertDialog.Builder(this)
                builder3.setTitle("Select your Choice")
                builder3.setIcon(R.drawable.baseline_format_list_numbered_24)
                builder3.setMultiChoiceItems(array,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    // perform action
                    Toast.makeText(this, "You have selected ${array[which]}",Toast.LENGTH_SHORT).show()
                })
                builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this,"Response Received !!", Toast.LENGTH_SHORT).show()
                })
                builder3.setNegativeButton("Reject",DialogInterface.OnClickListener { dialog, which ->
                    // action performed
                })
                builder3.show()
            }
    }
}