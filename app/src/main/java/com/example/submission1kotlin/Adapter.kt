package com.example.submission1kotlin

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext


class Adapter (private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ListAnko().createView(
        AnkoContext.Companion.create(context)))
    private var onAttach: Boolean = true
    private val duration: Long = 500

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
        setAnimation(holder.itemView, position)

    }

    private fun setAnimation(itemView: View, i: Int) {
        var i = i
        if (!onAttach) {
            i = -1
        }
        val isNotFirstItem = i == -1
        i ++
        itemView.translationX = itemView.x
        itemView.alpha = 0f
        val animatorSet = AnimatorSet()
        val animator = ObjectAnimator.ofFloat(itemView, "alpha", 0f, 1.0f, 2.0f)
        ObjectAnimator.ofFloat(itemView, "alpha", 0f).start()
        animator.startDelay = if (isNotFirstItem) duration / 2 else i * duration / 3
        animator.duration = 500
        animatorSet.play(animator)
        animator.start()
    }


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val tag = "MovieAdapter"
                Log.d(tag, "onScrollStateChanged: Called $newState")
                onAttach = false
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
        super.onAttachedToRecyclerView(recyclerView)
    }

    class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        fun bind(items: Item, listener: (Item) -> Unit) {
            val name = itemView.findViewById<TextView>(ListAnko.name)
            val image = itemView.findViewById<ImageView>(ListAnko.image)

            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}