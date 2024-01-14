package com.example.listviewproject2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.zip.Inflater

class MyAdapter(val context : Activity, val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.eachrowitem,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachrowitem, null)

        //Initializing values for 4 elements in EachRowItem

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val userName = view.findViewById<TextView>(R.id.textViewName)
        val userLastMssge = view.findViewById<TextView>(R.id.textViewMessage)
        val mssgeLastTime = view.findViewById<TextView>(R.id.textViewTime)

        //Defining completed, now set the values for eaach row by getting each index values

        userName.text = arrayList[position].name
        userLastMssge.text = arrayList[position].lastmessage
        mssgeLastTime.text = arrayList[position].lastmessageTime
        image.setImageResource(arrayList[position].imageId)

        return view
    }
}