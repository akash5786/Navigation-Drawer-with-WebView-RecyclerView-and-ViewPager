package com.example.navigationdrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val items: List<ItemsView>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem= items[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView.text = currentItem.text
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageview)
    val textView: TextView = itemView.findViewById(R.id.textView)

}
