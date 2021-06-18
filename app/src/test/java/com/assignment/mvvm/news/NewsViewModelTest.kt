package com.assignment.mvvm.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assignment.mvvm.arch.Failure
import com.assignment.mvvm.arch.ViewState
import com.assignment.mvvm.arch.Result
import com.assignment.mvvm.data.repo.INewsRepository
import com.assignment.mvvm.data.NewsEntity
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.UnknownHostException


//TODO: Fix the failing tests for ViewModel class

class NewsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var getLatestNews: INewsRepository
    private lateinit var viewModel: NewsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = NewsViewModel(getLatestNews)
    }

    @Test
    fun `success response from repo should set list in liveData`() = runBlockingTest {
        val newsEntityList = arrayListOf(
            NewsEntity(
                id = 0, sourceId = "1", sourceName = "CNN",
                author = "author", title = "Title", description = "news description",
                url = "http://google.com",
                urlToImage = "http://google.com",
                content = "content", publishedAt = ""
            )
        )


        coEvery { getLatestNews.getLatestNews(any()) } returns Result.Success(newsEntityList)

        viewModel.fetchLatestNews()
        assert(viewModel.latestNews.value is ViewState.Success)
        assertEquals(viewModel.latestNews.value, ViewState.Success(newsEntityList))
    }

    @Test
    fun `Failure from repo should set failure in liveData`() {
        val failure =
            Failure(
                1,
                "Please check your internet connection and try again",
                UnknownHostException()
            )

        coEvery { getLatestNews.getLatestNews(any()) } returns Result.Error(failure)

        viewModel.fetchLatestNews()
        assert(viewModel.latestNews.value is ViewState.Error)
        assertEquals(viewModel.latestNews.value, ViewState.Error(failure))
    }

}