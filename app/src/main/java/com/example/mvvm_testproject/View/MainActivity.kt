package com.example.mvvm_testproject.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm_testproject.ViewModel.Home_Adapter
import com.example.mvvm_testproject.R
import com.example.mvvm_testproject.ViewModel.Single_Word_List_Adapter
import com.example.mvvm_testproject.ViewModel.WordViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WordViewModel
    private lateinit var adapter: Home_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<ViewPager2>(R.id.viewpager2)
        viewModel = ViewModelProvider(this)[WordViewModel::class.java]

        adapter = Home_Adapter(
            emptyList(),
            onTranslateClick = { index -> viewModel.toggleTranslate(index) },
            onPlayClick = { index -> viewModel.togglePlaying(index) },
            onStudyClick = { index -> viewModel.toggleStudying(index) }
        )

        recyclerView.adapter = adapter

        viewModel.words.observe(this) { list ->
            adapter.updateData(list)
        }

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.listViewPager)


        val tablist = listOf("所有" ,"學習中")
        // 設定 Adapter
        viewPager.adapter = Single_Word_List_Adapter(tablist)

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