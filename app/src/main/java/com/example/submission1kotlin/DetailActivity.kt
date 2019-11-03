package com.example.submission1kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_detail.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class DetailActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        info(intent.getIntExtra("Detail_key", 0))
        val detailKey = intent.getIntExtra("Detail_key", 0)

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_desc)

        Glide.with(this).load(image.getResourceId(detailKey,0)).into(club_img_logo)
        Glide.with(this).load(image.getResourceId(detailKey,0)).into(club_poster)
        club_text_name.text = name[detailKey]
        club_text_desc.text = description[detailKey]

        collapsing_bar.title = name[detailKey]
        collapsing_bar.setCollapsedTitleTextColor(resources.getColor(R.color.colorWhite))
        collapsing_bar.setExpandedTitleColor(resources.getColor(R.color.colorWhite))
    }
}
