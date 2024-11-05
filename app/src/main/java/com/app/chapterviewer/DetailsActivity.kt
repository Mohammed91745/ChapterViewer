// DetailsActivity.kt
package com.app.chapterviewer

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = intent.getStringExtra("title")
        val details = intent.getStringExtra("details")
        val imageResId = intent.getIntExtra("imageResId", 0)

        findViewById<TextView>(R.id.titleTextView).text = title
        findViewById<TextView>(R.id.detailsTextView).text = details
        findViewById<ImageView>(R.id.imageView).setImageResource(imageResId)
    }
}
