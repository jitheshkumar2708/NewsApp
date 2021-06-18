package com.assignment.mvvm.data.repo

import com.assignment.mvvm.arch.Result
import com.assignment.mvvm.data.NewsEntity

interface INewsRepository {

    suspend fun getLatestNews(country: String): Result<List<NewsEntity>>
    suspend fun getNewsById(id: Int): NewsEntity?
}