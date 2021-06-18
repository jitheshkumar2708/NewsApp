package com.assignment.mvvm.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assignment.mvvm.arch.Failure
import com.assignment.mvvm.arch.Result
import com.assignment.mvvm.arch.ViewState
import com.assignment.mvvm.data.repo.INewsRepository
import com.assignment.mvvm.data.NewsEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepo: INewsRepository
) : ViewModel() {

    val latestNews = MutableLiveData<ViewState<List<NewsEntity>>>()

    @JvmOverloads
    fun fetchLatestNews(country: String = "us") {
        latestNews.postValue(ViewState.Loading)

        GlobalScope.launch {
            when (val result = newsRepo.getLatestNews(country)) {
                is Result.Success -> onLatestNewsSuccess(result.data)
                is Result.Error -> onLatestNewsFailure(result.failure)
            }
        }

    }

    private fun onLatestNewsFailure(failure: Failure) {
        latestNews.postValue(ViewState.Error(failure))
    }

    private fun onLatestNewsSuccess(news: List<NewsEntity>) {
        latestNews.postValue(ViewState.Success(news))
    }
}