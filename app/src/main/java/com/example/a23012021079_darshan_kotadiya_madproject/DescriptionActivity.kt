package com.example.a23012021079_darshan_kotadiya_madproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val title = intent.getStringExtra("title")
        val imageResId = intent.getIntExtra("imageResId", 0)
        val description = intent.getStringExtra("description")
        val videoLink = intent.getStringExtra("videoLink")

        findViewById<TextView>(R.id.textTitle).text = title
        findViewById<TextView>(R.id.textDescription).text = description
        findViewById<ImageView>(R.id.imagePoster).setImageResource(imageResId)

        findViewById<Button>(R.id.btnWatchVideo).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoLink))
            startActivity(intent)
        }
    }
}
