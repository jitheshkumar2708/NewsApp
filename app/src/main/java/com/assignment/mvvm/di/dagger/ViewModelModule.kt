package com.assignment.mvvm.di.dagger

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
class ViewModelModule {

    @Provides
    fun getIOContext() : CoroutineContext  = Dispatchers.IO
}