package com.example.mvvm_testproject.ViewModel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_testproject.Model.SingleWordList
import com.example.mvvm_testproject.R

class Home_Adapter(
    private var items: List<SingleWordList>,
    private val onTranslateClick: (Int) -> Unit,
    private val onPlayClick: (Int) -> Unit,
    private val onStudyClick: (Int) -> Unit
) : RecyclerView.Adapter<Home_Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val singleTv: TextView = view.findViewById(R.id.singleTv)
        val translateBtn: Button = view.findViewById(R.id.translate_Btn)
        val playBtn: ImageButton = view.findViewById(R.id.PlayIBtn)
        val studyingBtn: ImageButton = view.findViewById(R.id.StudyingImgBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_word_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.singleTv.text = if (item.isTranslated) item.chinese else item.english
        holder.playBtn.setImageResource(
            if (item.isPlaying) R.drawable.baseline_stop_24
            else R.drawable.baseline_play_arrow_24
        )

        holder.studyingBtn.setImageResource(
            if (item.isStudying) R.drawable.outline_bookmark_check_24
            else R.drawable.baseline_bookmark_border_24
        )

        holder.translateBtn.setOnClickListener { onTranslateClick(position) }
        holder.playBtn.setOnClickListener { onPlayClick(position) }
        holder.studyingBtn.setOnClickListener { onStudyClick(position) }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItems: List<SingleWordList>) {
        items = newItems
        notifyDataSetChanged()
    }
}