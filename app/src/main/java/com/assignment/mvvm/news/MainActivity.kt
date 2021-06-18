package com.assignment.mvvm.news

import android.os.Bundle
import com.assignment.mvvm.R
import com.assignment.mvvm.arch.BaseActivity
import com.assignment.mvvm.ext.replaceFragment
import com.assignment.mvvm.databinding.ActivityMainBinding
import com.assignment.mvvm.news.list.NewsListFragment

const val TAG_LATEST_NEWS = "tag_latest_news"

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun init(savedInstanceState: Bundle?, binding: ActivityMainBinding) {
        replaceFragment(
            R.id.parent,
            NewsListFragment(),
            TAG_LATEST_NEWS,
            addToStack = false
        )
    }
}
