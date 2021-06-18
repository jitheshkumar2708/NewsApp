package com.assignment.mvvm.data.remote

import android.content.Context
import com.assignment.mvvm.R
import com.assignment.mvvm.arch.Failure
import java.net.UnknownHostException
import javax.inject.Inject

const val CODE_NO_INTERNET = 1
const val UNKNOWN_ERROR = 2

class FailureHandler @Inject constructor(private val context: Context) {

    fun handleException(exception: Exception): Failure {
        return when (exception) {
            is UnknownHostException -> Failure(
                CODE_NO_INTERNET,
                context.getString(R.string.no_internet),
                exception
            )
            else -> Failure(
                UNKNOWN_ERROR,
                context.getString(R.string.something_went_wrong),
                exception
            )
        }
    }
}