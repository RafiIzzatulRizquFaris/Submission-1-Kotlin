package com.example.submission1kotlin

import android.graphics.Typeface
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.support.v4.nestedScrollView

class DetailAnko : AnkoComponent<DetailActivity> {
    var collapsingToolbarLayout: CollapsingToolbarLayout? = null
    var clubPoster: ImageView? = null
    var clubImgLogo: ImageView? = null
    var clubTextName: TextView? = null
    var clubTextDesc: TextView? = null
    var toolbar: _Toolbar? = null
    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        constraintLayout {
            lparams{
                width = matchParent
                height = matchParent
            }

            coordinatorLayout {
                lparams{
                    width= matchParent
                    height= matchParent
                }
                fitsSystemWindows = true

                appBarLayout {
                    lparams{
                        width= matchParent
                        height= dip(300)
                    }
                    fitsSystemWindows = true

                    collapsingToolbarLayout = collapsingToolbarLayout {
                        id = Ids.collapsingToolbarLayout
                        fitsSystemWindows = true
                        setCollapsedTitleTextColor(resources.getColor(R.color.colorWhite))
                        setExpandedTitleColor(resources.getColor(R.color.colorWhite))
                        expandedTitleMarginEnd = dip(64)
                        expandedTitleMarginStart = dip(64)

                        clubPoster =  imageView {
                            id = Ids.clubPoster
                            scaleType = ImageView.ScaleType.FIT_CENTER
                        }.lparams(width= wrapContent, height = matchParent){
                            gravity = Gravity.CENTER
                            collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX
                        }

                        toolbar {
                            id = Ids.toolbar
                        }.lparams(width = matchParent, height = dimenAttr(R.attr.actionBarSize)){
                            collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
                        }

                    }.lparams( width= matchParent, height= matchParent){
                        scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                    }
                }
                nestedScrollView {
                    constraintLayout {
//                        clubImgLogo = imageView {
//                            id = Ids.clubImgLogo
//                        }.lparams(width = dip(100), height = dip(100)){
//                            topMargin = dip(32)
//                            endToEnd = ConstraintSet.PARENT_ID
//                            startToStart = ConstraintSet.PARENT_ID
//                            topToTop = ConstraintSet.PARENT_ID
//                        }

                        clubTextName = textView {
                            id = Ids.clubTextName
                            textSize = sp(10).toFloat()
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams(width = wrapContent, height = wrapContent){
                            topMargin = dip(32)
                            endToEnd = ConstraintSet.PARENT_ID
                            startToStart = ConstraintSet.PARENT_ID
                            topToTop = ConstraintSet.PARENT_ID
                        }

                        clubTextDesc = textView {
                            id = Ids.clubTextDesc
                            textSize = sp(7).toFloat()
                            setLineSpacing(2F, 1F)
                        }.lparams(width = dip(0), height = wrapContent){
                            marginStart = dip(16)
                            topMargin = dip(32)
                            marginEnd = dip(16)
                            endToEnd = ConstraintSet.PARENT_ID
                            startToStart = ConstraintSet.PARENT_ID
                            topToBottom = Ids.clubTextName
                        }

                    }.lparams(width= matchParent, height = matchParent)
                }.lparams{
                    width = matchParent
                    height = matchParent
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        }
    }

    companion object Ids{
        const val collapsingToolbarLayout = 3
        const val clubPoster = 4
        const val toolbar = 5
        const val clubImgLogo = 6
        const val clubTextName = 7
        const val clubTextDesc = 8
    }

}
