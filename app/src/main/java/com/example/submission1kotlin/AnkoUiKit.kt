package com.example.submission1kotlin

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
import com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.nestedScrollView

class AnkoUiKit : AnkoComponent<MainActivityUI> {
    var recyclerView: RecyclerView? = null

    override fun createView(ui: AnkoContext<MainActivityUI>)= with(ui) {
        linearLayout{
            orientation = LinearLayout.VERTICAL
            recyclerView = recyclerView {
                lparams(width = matchParent, height = matchParent)
            }
        }
    }
}


class ListAnko : AnkoComponent<Context>{
    lateinit var image: ImageView
    lateinit var name: TextView
    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        cardView {
            cardElevation = dip(2).toFloat()
            preventCornerOverlap = false
            elevation = dip(4).toFloat()
            radius = dip(15).toFloat()

            lparams{
                margin = dip(8)
                width = matchParent
                height = wrapContent
            }

            linearLayout{
                orientation = LinearLayout.HORIZONTAL

                imageView{
                    id = Ids.image
                }.lparams(width = dip(72), height = dip(72)){
                    margin = dip(16)
                }

                textView {
                    id = Ids.name
                    textSize = sp(8).toFloat()
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams(width = wrapContent, height = wrapContent){
                    topMargin = dip(30)
                }
            }.lparams{
                margin = dip(8)
            }

        }
    }

    companion object Ids {
        const val image = 1
        const val name = 2
    }
}