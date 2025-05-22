package com.example.mvvm_testproject.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_testproject.R

class Adapter(
    private val single_en: List<String>,
    private val single_cz: List<String>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var istranslate = false
    var isplaying = false

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btn = itemView.findViewById<Button>(R.id.translate_Btn)
        val singleTv = itemView.findViewById<TextView>(R.id.singleTv)
        val PlayIBtn = itemView.findViewById<ImageButton>(R.id.PlayIBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_word_card_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = single_en.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.singleTv.text = single_en[position]
        holder.btn.setOnClickListener {
            if (istranslate) {
                holder.singleTv.text = single_en[position]
                istranslate = !istranslate
            } else {
                holder.singleTv.text = single_cz[position]
                istranslate = !istranslate
            }
        }
        holder.PlayIBtn.setOnClickListener {
            if (isplaying) {
                holder.PlayIBtn.setImageResource(R.drawable.baseline_stop_24)
                isplaying = !isplaying
            } else {
                holder.PlayIBtn.setImageResource(R.drawable.baseline_play_arrow_24)
                isplaying = !isplaying
            }
        }
    }
}