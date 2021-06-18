package com.assignment.mvvm.repo

import com.assignment.mvvm.arch.Result
import com.assignment.mvvm.data.local.INewsStore
import com.assignment.mvvm.data.mapper.NewsModelToNewsMapper
import com.assignment.mvvm.data.remote.FailureHandler
import com.assignment.mvvm.data.remote.api.NewsApi
import com.assignment.mvvm.data.mapper.NewsToEntityMapper
import com.assignment.mvvm.data.remote.response.Status
import com.assignment.mvvm.data.remote.response.TopHeadlinesResponse
import com.assignment.mvvm.data.repo.impl.NewsRepositoryImpl
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NewsRepositoryImplTest {

    @MockK
    private lateinit var newsApi: NewsApi

    @MockK
    private lateinit var newsStore: INewsStore

    @MockK
    private lateinit var mapperNewsToEntity: NewsToEntityMapper

    @MockK
    private lateinit var mapper: NewsModelToNewsMapper

    @MockK
    private lateinit var failureHandler: FailureHandler

    private lateinit var newsRepository: NewsRepositoryImpl


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        newsRepository = NewsRepositoryImpl(newsApi, newsStore, mapperNewsToEntity, mapper, failureHandler)
    }

    @Test
    fun `success from server should clear local storage and insert new news`() {
        val newsList = TestUtils.getNewsList()
        val newsEntityList = TestUtils.getNewsEntityList()
        val newsModelList = TestUtils.getNewsModelList()
        val topHeadlinesResponse = TopHeadlinesResponse(
            status = Status.OK,
            totalResults = 1,
            newsModelList
        )

        coEvery { newsApi.getLatestNews(any()) } returns topHeadlinesResponse
        coJustRun { newsStore.insertNews(any()) }
        coJustRun { newsStore.deleteAll() }
        coEvery { newsStore.getLatestNews() } returns newsList
        every { mapperNewsToEntity.transform(newsList) } returns newsEntityList
        every { mapper.transform(newsModelList) } returns newsList

        runBlocking {
            val result = newsRepository.getLatestNews("us")
            assertEquals(Result.Success((newsEntityList)), result)
        }
        coVerify(exactly = 1) { newsStore.deleteAll() }
        coVerify(exactly = 1) { newsStore.insertNews(newsList) }
        coVerify(exactly = 1) { newsStore.getLatestNews() }
    }

    @Test
    fun `zero records from server should not clear the local DB and return cache news`() {
        val newsList = TestUtils.getNewsList()
        val newsEntityList = TestUtils.getNewsEntityList()
        val topHeadlinesResponse = TopHeadlinesResponse(
            status = Status.OK,
            totalResults = 0,
            arrayListOf()
        )

        coEvery { newsApi.getLatestNews(any()) } returns topHeadlinesResponse
        coEvery { newsStore.getLatestNews() } returns newsList
        every { mapperNewsToEntity.transform(newsList) } returns newsEntityList

        runBlocking {
            val result = newsRepository.getLatestNews("us")
            assertEquals(Result.Success((newsEntityList)), result)
        }
        coVerify(exactly = 1) { newsStore.getLatestNews() }
        coVerify(exactly = 0) { newsStore.deleteAll() }
        coVerify(exactly = 0) { newsStore.insertNews(any()) }
    }

    @Test
    fun `cached news should fetch news from DB`() {
        val newsList = TestUtils.getNewsList()
        val newsEntityList = TestUtils.getNewsEntityList()
        every { mapperNewsToEntity.transform(newsList) } returns newsEntityList
        coEvery { newsStore.getLatestNews() } returns newsList
        runBlocking {
            val result = newsRepository.cachedNews()
            assertEquals(newsEntityList, result)
        }

        coVerify(exactly = 1) { newsStore.getLatestNews() }

    }

    //TODO: Complete the test cases
    @Test
    fun `if there is record in DB it should be returned`() {

    }

    //TODO: Complete the test cases
    @Test
    fun `if there is no record in DB null should be returned`() {

    }


}