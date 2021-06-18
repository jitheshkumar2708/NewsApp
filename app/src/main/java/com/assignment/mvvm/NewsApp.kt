package com.assignment.mvvm

import android.app.Application
import com.assignment.mvvm.di.dagger.AppComponent
import com.assignment.mvvm.di.dagger.DaggerAppComponent


class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDaggerComponent()
    }

    private fun initDaggerComponent() {
        appComponent = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}