package com.assignment.mvvm.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {
    @Query("SELECT * FROM News")
    suspend fun getLatestNews(): List<News>

    @Insert
    suspend fun insertAll(vararg news: News)

    @Query("DELETE FROM News")
    suspend fun clear()

    @Query("SELECT * FROM News WHERE id = :id")
    suspend fun findById(id: Int): News?
}