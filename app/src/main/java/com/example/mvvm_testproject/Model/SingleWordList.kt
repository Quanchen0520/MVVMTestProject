package com.example.mvvm_testproject.Model

data class SingleWordList(
    val english: String,
    val chinese: String,
    var isTranslated: Boolean = false,
    var isPlaying: Boolean = false
)