package com.assignment.mvvm.data.mapper

import com.assignment.mvvm.data.NewsEntity
import com.assignment.mvvm.data.local.News
import javax.inject.Inject

class NewsToEntityMapper @Inject constructor() : Mapper<News, NewsEntity> {
    override fun transform(model: News): NewsEntity {
        return NewsEntity(
            id = model.id,
            sourceName = model.source?.sourceName,
            sourceId = model.source?.sourceId,
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.thumbnailUrl,
            publishedAt = model.publishedAt,
            content = model.content

        )
    }

    override fun transform(models: List<News>): List<NewsEntity> {
        return models.map {
            transform(it)
        }
    }
}