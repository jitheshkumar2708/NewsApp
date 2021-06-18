package com.assignment.mvvm.data.local

import javax.inject.Inject

class NewsStore @Inject constructor(private val newsDao: NewsDao) : INewsStore {

    override suspend fun getLatestNews(): List<News> {
        return newsDao.getLatestNews()
    }

    override suspend fun insertNews(list: List<News>) {
        newsDao.insertAll(*list.toTypedArray())
    }

    override suspend fun deleteAll() {
        newsDao.clear()
    }

    override suspend fun getNewsById(id: Int): News? {
        return newsDao.findById(id)
    }
}