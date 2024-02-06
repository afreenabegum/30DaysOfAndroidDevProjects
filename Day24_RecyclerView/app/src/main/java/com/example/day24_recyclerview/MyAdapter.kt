package com.example.day24_recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList : ArrayList<News>, var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{

    // Method used to create view instance,when layout manager fails to find suitable view for item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_rowitem,parent,false)
        return MyViewHolder(itemView)
    }

    // Populating or keeping data in views
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var currentItemIndex = newsArrayList[position]
        holder.hTitle.text = currentItemIndex.newsHeading
        holder.hImage.setImageResource(currentItemIndex.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // Holds Views as views are not created everytime, so memory can be saved
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val hTitle = itemView.findViewById<TextView>(R.id.tVHeading)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.HeadingImage)
    }
}

