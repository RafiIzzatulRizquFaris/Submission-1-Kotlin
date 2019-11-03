package com.example.submission1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivity: AnkoUiKit
    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = AnkoUiKit()
        mainActivity.setContentView(this)
        getData()
        mainActivity.recycler!!.layoutManager = LinearLayoutManager(this)
        mainActivity.recycler!!.adapter = Adapter(this, items){
            startActivity<DetailActivity>("Detail_key" to items.indexOf(it))
        }
    }

    private fun getData(){
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)
        val image = resources.obtainTypedArray(R.array.club_image)

        for (i in name.indices){
            items.add(Item(name[i], desc[i], image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}
