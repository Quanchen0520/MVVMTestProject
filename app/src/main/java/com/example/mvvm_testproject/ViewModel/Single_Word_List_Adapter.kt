package com.example.mvvm_testproject.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_testproject.R

 class Single_Word_List_Adapter(
    private val tabList: List<String>
) : RecyclerView.Adapter<Single_Word_List_Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val singleword: TextView = view.findViewById(R.id.SingleWord)
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.single_word_list, parent, false)
         return  ViewHolder(view)
     }

     override fun getItemCount(): Int  = tabList.size

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.singleword.text = tabList[position]
     }
 }
