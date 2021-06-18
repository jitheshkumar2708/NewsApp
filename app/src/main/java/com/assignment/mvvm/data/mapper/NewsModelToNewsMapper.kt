package com.assignment.mvvm.data.mapper

import com.assignment.mvvm.data.local.News
import com.assignment.mvvm.data.local.Source
import com.assignment.mvvm.data.remote.response.model.NewsModel
import javax.inject.Inject

class NewsModelToNewsMapper @Inject constructor() : Mapper<NewsModel, News> {
    override fun transform(model: NewsModel): News {
        return News(
            id = 0,
            source = Source(model.source.id, model.source.name),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            thumbnailUrl = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content
        )
    }

    override fun transform(models: List<NewsModel>): List<News> {
        return models.map {
            transform(it)
        }
    }
}