package com.example.a23012021079_darshan_kotadiya_madproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class ContentItem(
    val title: String,
    val imageResId: Int,
    val playCount: String
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tabs
        val tabPopular = findViewById<View>(R.id.tab_popular)
        val contentPopular = findViewById<View>(R.id.content_popular_section)

        // Default screen
        switchTab(tabPopular, contentPopular)

        // Load grid correctly
        populatePopularGrid()
    }

    private fun populatePopularGrid() {

        val sampleData = listOf(
            ContentItem("After", R.drawable.ic_movie_1, "1.8L"),
            ContentItem("Alien", R.drawable.ic_movie_2, "24.1Cr"),
            ContentItem("Archer", R.drawable.ic_movie_3, "3.0L"),
            ContentItem("Avtar", R.drawable.ic_movie_4, "1.4L"),
            ContentItem("Divided", R.drawable.ic_movie_5, "1.2L"),
            ContentItem("Oppenheimer", R.drawable.ic_movie_6, "54.5L"),
            ContentItem("Roghe One", R.drawable.ic_movie_7, "39.1K"),
            ContentItem("Star Wars", R.drawable.ic_movie_8, "2.8L"),
            ContentItem("Wonder Women", R.drawable.ic_movie_9, "15.0L")
        )

        val container = findViewById<View>(R.id.content_popular_section)

        val rowIds = listOf(R.id.row1, R.id.row2, R.id.row3)
        val cardIds = listOf(R.id.card1, R.id.card2, R.id.card3)

        var index = 0

        for (rowId in rowIds) {
            val rowView = container.findViewById<View>(rowId)

            for (cardId in cardIds) {
                val cardView = rowView.findViewById<View>(cardId)
                val item = sampleData[index]

                val titleTv = cardView.findViewById<TextView>(R.id.text_title)
                val posterImg = cardView.findViewById<ImageView>(R.id.image_poster)
                val playTv = cardView.findViewById<TextView>(R.id.text_play_count)

                titleTv.text = item.title
                playTv.text = item.playCount
                posterImg.setImageResource(item.imageResId)

                index++
                cardView.setOnClickListener {
                    val intent = Intent(this, DescriptionActivity::class.java)
                    intent.putExtra("title", item.title)
                    intent.putExtra("imageResId", item.imageResId)
                    intent.putExtra("description", "This is a description for " +
                            "you can watch your video here " + item.title)
                    intent.putExtra("videoLink", "https://www.youtube.com/results?search_query=movie+" + index) // Replace with your actual video URLs
                    startActivity(intent)
                }

            }
        }
    }

    private fun switchTab(selectedTab: View, targetContent: View) {
        val contentPopular = findViewById<View>(R.id.content_popular_section)
        contentPopular.visibility = View.GONE
        targetContent.visibility = View.VISIBLE
    }
}
