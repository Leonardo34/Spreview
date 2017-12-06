package com.example.leonardomorais.myapplication
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
        setContentView(R.layout.activity_feed)

        slidingTabLayout = findViewById<View>(R.id.stl_tabs) as SlidingTabLayout
        slidingTabLayout!!.setDistributeEvenly(true)
        slidingTabLayout!!.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.colorPrimaryDark))

        viewPager = findViewById<View>(R.id.vp_main_feed) as ViewPager

        val tabAdapter = TabAdapter(supportFragmentManager)
        viewPager!!.adapter = tabAdapter

        slidingTabLayout!!.setViewPager(viewPager)
    }
}
