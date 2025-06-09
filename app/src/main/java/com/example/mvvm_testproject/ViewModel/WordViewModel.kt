package com.example.mvvm_testproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_testproject.Model.SingleWordList

class WordViewModel : ViewModel() {

    private val _words = MutableLiveData<List<SingleWordList>>()
    val words: LiveData<List<SingleWordList>> = _words

    init {
        _words.value = listOf(
            SingleWordList("Apple", "蘋果"),
            SingleWordList("Banana", "香蕉"),
            SingleWordList("Watermelon", "西瓜")
        )
    }

    fun toggleTranslate(index: Int) {
        _words.value = _words.value?.toMutableList()?.apply {
            this[index] = this[index].copy(isTranslated = !this[index].isTranslated)
        }
    }

    fun togglePlaying(index: Int) {
        _words.value = _words.value?.toMutableList()?.apply {
            this[index] = this[index].copy(isPlaying = !this[index].isPlaying)
        }
    }

    fun toggleStudying(index: Int) {
        _words.value = _words.value?.toMutableList()?.apply {
            this[index] = this[index].copy(isStudying = !this[index].isStudying)
        }
    }
}