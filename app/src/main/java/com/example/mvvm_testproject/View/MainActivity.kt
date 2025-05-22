package com.example.mvvm_testproject.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm_testproject.ViewModel.Adapter
import com.example.mvvm_testproject.R
import com.example.mvvm_testproject.ViewModel.Single_Word_List_Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val single_en = listOf("Apple", "Banana", "Watermelon")
        val singe_cz = listOf("蘋果", "香蕉", "西瓜")
        viewPager2.adapter = Adapter(single_en, singe_cz)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.listViewPager)

        // 設定 Adapter
        viewPager.adapter = Single_Word_List_Adapter(this)

        // 連接 TabLayout 與 ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "所有"
                1 -> "學習中"
                else -> "Tab ${position + 1}"
            }
        }.attach()
    }
}