package com.example.submission1kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.setContentView


class DetailActivity : AppCompatActivity(), AnkoLogger {

    private lateinit var detailAnko: DetailAnko

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailAnko = DetailAnko()
        detailAnko.setContentView(this)
        info(intent.getIntExtra("Detail_key", 0))
        val intentLeague : Item? = intent.getParcelableExtra("detail")

        detailAnko.clubPoster?.let { Glide.with(this).load(intentLeague!!.image).into(it) }
        detailAnko.clubTextName!!.text = intentLeague!!.name
        detailAnko.clubTextDesc!!.text = intentLeague.desc

        detailAnko.collapsingToolbarLayout!!.title = intentLeague.name
    }
}
