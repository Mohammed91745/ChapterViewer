// MainActivity.kt
package com.app.chapterviewer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val chapters = listOf(
            Chapter("Chapter One", "Item one details", R.drawable.android_image_1),
            Chapter("Chapter Two", "Item two details", R.drawable.android_image_2),
            Chapter("Chapter Three", "Item three details", R.drawable.android_image_3),
            Chapter("Chapter Four", "Item four details", R.drawable.android_image_4),
            Chapter("Chapter Five", "Item five details", R.drawable.android_image_5),
            Chapter("Chapter Six", "Item six details", R.drawable.android_image_6),

            // Add more items as needed
        )

        val adapter = ChapterAdapter(this, chapters) { chapter ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("title", chapter.title)
            intent.putExtra("details", chapter.details)
            intent.putExtra("imageResId", chapter.imageResId)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
