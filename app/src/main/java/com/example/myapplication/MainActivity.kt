package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        val messages = listOf(
            "Keep going!",
            "You're doing great!",
            "Awesome clicks!",
            "Click master!",
            "You rock!"
        )

        button.setOnClickListener {
            clickCount++
            button.text = "Clicked $clickCount times"

            // Change message every 3 clicks
            val msgIndex = (clickCount / 3) % messages.size
            textView.text = messages[msgIndex]
        }
    }
}
