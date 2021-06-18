package com.assignment.mvvm.data.remote.response.model

data class NewsModel(
    val source: SourceModel,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
