package com.assignment.mvvm.data.local

interface INewsStore {
    suspend fun getLatestNews(): List<News>
    suspend fun insertNews(list: List<News>)
    suspend fun deleteAll()
    suspend fun getNewsById(id: Int) : News?
}