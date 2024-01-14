package com.example.listview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewId = findViewById<ListView>(R.id.listview)

        val dataArray = arrayListOf<String>()

        dataArray.add("Complete Project 1 of ListView")
        dataArray.add("Complete GitHub next Tutorial")
        dataArray.add("Work on Resume")
        dataArray.add("Work on some Extra Projects")
        dataArray.add("Make Social Presence")

        // Adapter is something is like connection
        // So Enabling Adapter between the data and ListView. So the data is displayed in ListView

        val adapterOfListView = ArrayAdapter(this,android.R.layout.simple_list_item_1,dataArray)

        //Defining Adapter is completed now connect our (data + Adapter) to the ListView
        // We have total data in the Adapter itself

        listViewId.adapter = adapterOfListView

        // Code implemented when action occurs, for clicking each item in ListView

        listViewId.setOnItemClickListener { parent, view, position, id ->

            val text = " Clicked on " + (view as TextView).text.toString()
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()

        }


    }
}