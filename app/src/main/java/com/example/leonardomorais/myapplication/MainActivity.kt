package com.example.leonardomorais.myapplication
import android.content.Intent
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View

import com.example.leonardomorais.myapplication.Adapter.TabAdapter
import com.example.leonardomorais.myapplication.Helper.SlidingTabLayout
import com.example.leonardomorais.myapplication.R

class MainActivity : AppCompatActivity() {

    private var slidingTabLayout: SlidingTabLayout? = null

    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)
    }
}
