package com.assignment.mvvm.di.dagger

import android.content.Context
import com.assignment.mvvm.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun getDB(context: Context) = AppDatabase(context)

    @Provides
    fun getNewsDao(appDatabase: AppDatabase) = appDatabase.newsDao()
}