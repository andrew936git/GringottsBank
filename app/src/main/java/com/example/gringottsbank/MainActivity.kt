package com.example.gringottsbank

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(this, Picture.pictureList)
        val viewPagerVP = findViewById<ViewPager2>(R.id.viewPagerVP)
        viewPagerVP.adapter = adapter

    }
}