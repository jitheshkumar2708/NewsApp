package com.assignment.mvvm.di.dagger

import android.content.Context
import com.assignment.mvvm.news.MainActivity
import com.assignment.mvvm.news.list.NewsListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DbModule::class, NetworkModule::class, RepositoryModule::class, ViewModelModule::class]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(listFragment: NewsListFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}