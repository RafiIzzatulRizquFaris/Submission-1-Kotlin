package com.example.submission1kotlin

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class AnkoUiKit : AnkoComponent<MainActivity> {
    var recycler: RecyclerView? = null

    override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
        linearLayout{
            orientation = LinearLayout.VERTICAL
            recycler =recyclerView {
                lparams(width = matchParent, height = matchParent)
            }
        }
    }
}

class ListAnko : AnkoComponent<Context>{
    lateinit var image: ImageView
    lateinit var name: TextView
    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        linearLayout{
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            imageView{
                id = Ids.image
            }.lparams(width = dip(72), height = dip(72)){
                margin = dip(16)
            }

            textView {
                id = Ids.name
                textSize = sp(20).toFloat()
                typeface = Typeface.DEFAULT_BOLD
            }.lparams(width = wrapContent, height = wrapContent){
                topMargin = dip(30)
            }
        }
    }

    companion object Ids {
        const val image = 1
        const val name = 2
    }

}