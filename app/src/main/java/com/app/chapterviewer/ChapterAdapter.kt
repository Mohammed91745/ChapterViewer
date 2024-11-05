// ChapterAdapter.kt
package com.app.chapterviewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChapterAdapter(
    private val context: Context,
    private val chapters: List<Chapter>,
    private val onItemClick: (Chapter) -> Unit
) : RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_chapter, parent, false)
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.titleTextView.text = chapter.title
        holder.detailsTextView.text = chapter.details
        holder.imageView.setImageResource(chapter.imageResId)
        holder.itemView.setOnClickListener { onItemClick(chapter) }
    }

    override fun getItemCount(): Int = chapters.size

    class ChapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val detailsTextView: TextView = view.findViewById(R.id.detailsTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}
