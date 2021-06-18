package com.assignment.mvvm.news.list

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import com.assignment.mvvm.NewsApp
import com.assignment.mvvm.R
import com.assignment.mvvm.arch.BaseFragment
import com.assignment.mvvm.arch.ViewState
import com.assignment.mvvm.data.NewsEntity
import com.assignment.mvvm.ext.changeStatusBarColor
import com.assignment.mvvm.databinding.NewsListFragmentBinding
import com.assignment.mvvm.news.NewsViewModel
import com.assignment.mvvm.news.list.adapter.NewsListAdapter
import javax.inject.Inject

class NewsListFragment : BaseFragment<NewsListFragmentBinding>(R.layout.news_list_fragment) {

    @Inject
    lateinit var newsViewModel: NewsViewModel

    private lateinit var binding: NewsListFragmentBinding

    private val newsListAdapter = NewsListAdapter { newsItem, sharedElements ->
        // TODO: Implement NewsDetailScreen and open the same on item click
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel.fetchLatestNews()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        NewsApp.appComponent.inject(this)
    }

    override fun init(savedInstanceState: Bundle?, binding: NewsListFragmentBinding) {
        this.binding = binding
        activity!!.changeStatusBarColor(R.color.black)

        newsViewModel.latestNews.observe(viewLifecycleOwner) {
            render(it)
        }

        binding.recycleLatestNews.adapter = newsListAdapter
        binding.viewModel = newsViewModel

        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(R.transition.shared_transition)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pullToRefresh.setOnRefreshListener {
            newsViewModel.fetchLatestNews()
            binding.pullToRefresh.isRefreshing = false
        }
    }

    private fun render(state: ViewState<List<NewsEntity>>) {
        when (state) {
            is ViewState.Success -> {
                newsListAdapter.submitList(state.item)
                newsListAdapter.notifyDataSetChanged()
            }
            is ViewState.Error -> {
                binding.txtError.text = state.failure.message
            }
        }
    }
}