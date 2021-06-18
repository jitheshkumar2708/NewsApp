package com.assignment.mvvm.news.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.mvvm.R
import com.assignment.mvvm.databinding.NewsListItemBinding
import com.assignment.mvvm.data.NewsEntity

class NewsListAdapter(private val onNewsSelect: (NewsEntity, List<Pair<View, String>>) -> Unit) :
    ListAdapter<NewsEntity, NewsListAdapter.NewsItemVH>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemVH {
        val itemLayoutBinding = DataBindingUtil.inflate<NewsListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.news_list_item, parent, false
        )
        return NewsItemVH(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: NewsItemVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NewsItemVH(private val binding: NewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newsItem: NewsEntity) {
            binding.item = newsItem
            binding.parent.setOnClickListener {
                onNewsSelect.invoke(
                    newsItem, emptyList()
                )
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NewsEntity>() {
        override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem == newItem
        }
    }
}