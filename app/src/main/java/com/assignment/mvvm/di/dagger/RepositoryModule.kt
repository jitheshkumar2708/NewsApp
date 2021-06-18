package com.assignment.mvvm.di.dagger

import com.assignment.mvvm.data.local.INewsStore
import com.assignment.mvvm.data.local.NewsStore
import com.assignment.mvvm.data.repo.INewsRepository
import com.assignment.mvvm.data.repo.impl.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): INewsRepository

    @Binds
    abstract fun bindNewsStore(newsStore: NewsStore) : INewsStore
}