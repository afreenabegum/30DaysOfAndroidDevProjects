package com.example.day24_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing

        recyclerView = findViewById(R.id.recyclerView)

        // Preparing Data
        var newsImageArray = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7
        )

        var newsHeadingArray = arrayOf("Kamal Haasan on Ram Mandir: ‘My answer is same as what it was 30 years ago’\n" +
                "Actor-politician Kamal Haasan referred to his statement made when Babri Masjid was demolished back on December 6, 1991.",
            "Rohan Bopanna makes history as oldest ATP World No. 1 at 2024 Australian Open",
            "Virat Kohli to R Ashwin: India's Top Performers in Test Against England",
            "Mother of all Breaches’: 26 billion data records stolen from sites like X, LinkedIn",
            "Teenager develops device to help Alzheimer patient",
            "Top 10 wealthiest billionaires in food and beverages industry: There's 1 Indian tycoon on the list",
            "Wipro founder Azim Premji gifts shares worth about ₹500 cr to his sons: Report"
        )

        // Setting Actions to RV
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initializing Array with Data Class
        newsArrayList = arrayListOf<News>()

        // Using For loop preparing Data in News Data Class

        for (index in newsImageArray.indices){
            val eachNewsInfo = News(newsHeadingArray[index],newsImageArray[index])
            // Adding item into ArrayList
            newsArrayList.add(eachNewsInfo)
        }

        // setting Adapter
        recyclerView.adapter = MyAdapter(newsArrayList,this)

    }
}