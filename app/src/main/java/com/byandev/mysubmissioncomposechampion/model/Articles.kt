package com.byandev.mysubmissioncomposechampion.model

data class Articles(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
) : java.io.Serializable