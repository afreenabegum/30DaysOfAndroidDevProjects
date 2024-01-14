package com.example.dynamicphotoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage =0
    lateinit var image :ImageView
    var names = arrayOf("Saumya Singh", "Afreen", "App Dev", "Code Mode : )")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prevBtn = findViewById<ImageButton>(R.id.imageViewPrev)
        val nextBtn = findViewById<ImageButton>(R.id.imageViewNext)
        var nametext = findViewById<TextView>(R.id.textView)

        prevBtn.setOnClickListener {
            // storing current image id in a variable, by default it will be pic0
            val currentImageIdString = "pic$currentImage"
            //Converting String to int
            val currentImageIdInt = this.resources.getIdentifier(currentImageIdString,"id",packageName)
            //Above this is converted to int, now we can find that image in int format
            image = findViewById(currentImageIdInt)
            // we have which image should not ne displaced, if previous btn is pressed.
            image.alpha = 0f


            //Code to display prev image
            currentImage = (4+(currentImage-1))%4
            val imageShowString = "pic$currentImage"
            //converting above string type to int
            val imageShowInt = this.resources.getIdentifier(imageShowString,"id",packageName)
            image = findViewById(imageShowInt)
            image.alpha = 1f
            nametext.text = names[currentImage]

        }

        nextBtn.setOnClickListener {
            val currentImageIdString = "pic$currentImage"
            //Converting String to int
            val currentImageIdInt = this.resources.getIdentifier(currentImageIdString,"id",packageName)
            //Above this is converted to int, now we can find that image in int format
            image = findViewById(currentImageIdInt)
            // we have which image should not ne displaced, if previous btn is pressed.
            image.alpha = 0f


            //Code to display next image
            currentImage = (4+(currentImage+1))%4
            val imageShowString = "pic$currentImage"
            //converting above string type to int
            val imageShowInt = this.resources.getIdentifier(imageShowString,"id",packageName)
            image = findViewById(imageShowInt)
            image.alpha = 1f
            nametext.text = names[currentImage]
        }
    }
}