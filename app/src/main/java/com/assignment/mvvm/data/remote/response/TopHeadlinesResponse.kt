package com.assignment.mvvm.data.remote.response

import com.assignment.mvvm.data.remote.response.model.NewsModel

data class TopHeadlinesResponse(
    val status: Status,
    val totalResults: Int?,
    val articles: List<NewsModel>
)

enum class Status(
    val value: String
) {
    OK("ok"),
    ERROR("error")
}