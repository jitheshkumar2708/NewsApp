package com.assignment.mvvm.repo

import com.assignment.mvvm.data.local.News
import com.assignment.mvvm.data.local.Source
import com.assignment.mvvm.data.remote.response.model.NewsModel
import com.assignment.mvvm.data.remote.response.model.SourceModel
import com.assignment.mvvm.data.NewsEntity


object TestUtils {
    fun getNewsList() = arrayListOf(
        News(
            id = 0, source = Source("1", "CNN"),
            author = "author", title = "Title", description = "news description",
            url = "http://google.com",
            thumbnailUrl = "http://google.com",
            content = "content", publishedAt = ""
        )
    )

    fun getNewsEntityList() = arrayListOf(
        NewsEntity(
            id = 0, sourceId = "1", sourceName = "CNN",
            author = "author", title = "Title", description = "news description",
            url = "http://google.com",
            urlToImage = "http://google.com",
            content = "content", publishedAt = ""
        )
    )

    fun getNewsModelList() = arrayListOf(
        NewsModel(
            source = SourceModel("1", "CNN"),
            title = "Title",
            author = "author",
            description = "news description",
            url = "http://google.com",
            urlToImage = "http://google.com",
            content = "content", publishedAt = ""
        )
    )
}
