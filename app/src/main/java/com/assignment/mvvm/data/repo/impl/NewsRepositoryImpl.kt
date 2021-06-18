package com.assignment.mvvm.data.repo.impl

import androidx.annotation.VisibleForTesting
import com.assignment.mvvm.arch.Result
import com.assignment.mvvm.data.local.INewsStore
import com.assignment.mvvm.data.mapper.NewsModelToNewsMapper
import com.assignment.mvvm.data.remote.FailureHandler
import com.assignment.mvvm.data.remote.api.NewsApi
import com.assignment.mvvm.data.repo.INewsRepository
import com.assignment.mvvm.data.mapper.NewsToEntityMapper
import com.assignment.mvvm.data.NewsEntity
import javax.inject.Inject

open class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val newsStore: INewsStore,
    private val mapperNewsToEntity: NewsToEntityMapper,
    private val mapperNewsModelToNews: NewsModelToNewsMapper,
    private val failureHandler: FailureHandler
) : INewsRepository {

    override suspend fun getLatestNews(country: String): Result<List<NewsEntity>> {
        return try {
            val response = newsApi.getLatestNews(country)
            if (response.totalResults != 0) {
                newsStore.deleteAll()
                newsStore.insertNews(mapperNewsModelToNews.transform(response.articles))
            }
            Result.Success(cachedNews())
        } catch (ex: Exception) {
             Result.Error(failureHandler.handleException(ex))
        }
    }

    override suspend fun getNewsById(id: Int): NewsEntity? {
       return cachedNews().find { it.id == id }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    suspend fun cachedNews(): List<NewsEntity> {
        return mapperNewsToEntity.transform(newsStore.getLatestNews())
    }
}