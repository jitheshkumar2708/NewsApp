package com.assignment.mvvm.data.remote.api

import com.assignment.mvvm.data.remote.response.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getLatestNews(
        @Query("country") countryCode: String,
        @Query("pageSize") pageSize: Int = 100
    ): TopHeadlinesResponse
}