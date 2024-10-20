package com.assessmentfinal.assessmentfinal.activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.assessmentfinal.assessmentfinal.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Find views by their IDs
        val entityNameTextView = findViewById<TextView>(R.id.entity_name)
        val entityArchitectTextView = findViewById<TextView>(R.id.entity_architect)
        val entityLocationTextView = findViewById<TextView>(R.id.entity_location)
        val entityYearTextView = findViewById<TextView>(R.id.entity_year)
        val entityStyleTextView = findViewById<TextView>(R.id.entity_style)
        val entityHeightTextView = findViewById<TextView>(R.id.entity_height)
        val entityDescriptionTextView = findViewById<TextView>(R.id.entity_description)
        val backButton = findViewById<ImageButton>(R.id.back_button)

        // Get the intent extras
        val name = intent.getStringExtra("ENTITY_NAME")
        val architect = intent.getStringExtra("ENTITY_ARCHITECT")
        val location = intent.getStringExtra("ENTITY_LOCATION")
        val yearCompleted = intent.getIntExtra("ENTITY_YEAR", -1)
        val style = intent.getStringExtra("ENTITY_STYLE")
        val height = intent.getIntExtra("ENTITY_HEIGHT", -1)
        val description = intent.getStringExtra("ENTITY_DESCRIPTION")

        // back button functionality
        backButton.setOnClickListener { finish() }


        // Bind the data to the TextViews
        entityNameTextView.text = name
        entityArchitectTextView.text = architect
        entityLocationTextView.text = location
        entityYearTextView.text = if (yearCompleted != -1) yearCompleted.toString() else "N/A"
        entityStyleTextView.text = style
        entityHeightTextView.text = if (height != -1) "$height meters" else "N/A"
        entityDescriptionTextView.text = description
    }
}