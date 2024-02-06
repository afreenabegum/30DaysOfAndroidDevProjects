package com.example.portfolio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val twitterid = findViewById<ImageView>(R.id.twitter)
        val linkedinid = findViewById<ImageView>(R.id.linkedIn)
        val githubid = findViewById<ImageView>(R.id.github)
        val emailid = findViewById<ImageView>(R.id.email)
        val projectlist = findViewById<Button>(R.id.projects)

        twitterid.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://twitter.com/afreenabegum74")
            startActivity(intent)
        }

        linkedinid.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/afreena-begum-113b23200/")
            startActivity(intent)
        }

        githubid.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/afreenabegum")
            startActivity(intent)
        }

        emailid.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("mailto:afreenabegum74@gmail.com"));
            startActivity(intent)
        }

        projectlist.setOnClickListener {
            val intent = Intent(this,Projects::class.java)
            startActivity(intent)
        }
    }
}