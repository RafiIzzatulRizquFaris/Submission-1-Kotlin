package com.example.submission1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getData(){
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)
        val image = resources.obtainTypedArray(R.array.club_image)

        for (i in name.indices){
            items.add(Item(name[i], desc[i], image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}
