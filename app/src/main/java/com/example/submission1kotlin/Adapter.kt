package com.example.submission1kotlin

import android.content.Context
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

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
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