package com.example.listviewproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userDataList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Afreen", "Saumya","Tanishq","Chahal","Fariya")
        val lastmessage = arrayOf("Hi,How are You?" , "Awesome !", "All fine?",  "Cool", "Done")
        val lastmessageTime = arrayOf("12:40 PM", "1:00 PM", " 3:30 AM", "7:06 PM","10:00 PM")
        val phoneNumber = arrayOf("9999999999","7878787878","9898989898","6786786786","8976897689")
        val imageId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5)

        userDataList = ArrayList()

        for(eachindexValue in name.indices){
            val userInfo = User(name[eachindexValue],lastmessage[eachindexValue],lastmessageTime[eachindexValue],phoneNumber[eachindexValue],imageId[eachindexValue])

            userDataList.add(userInfo)
        }

        val listViewId = findViewById<ListView>(R.id.ListViewId)
        //Enabling Adapter

        //Creating my own Adapter to store user Information
        listViewId.adapter = MyAdapter(this, userDataList)
    }
}