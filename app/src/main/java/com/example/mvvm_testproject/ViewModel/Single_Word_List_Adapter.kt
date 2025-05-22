package com.example.mvvm_testproject.ViewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Single_Word_List_Adapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val tabTitles = listOf("所有", "學習中")

    override fun getItemCount(): Int = tabTitles.size

    override fun createFragment(position: Int): Fragment {
        return AllSingleWordFragment.newInstance(tabTitles[position])
    }

}
