package com.assignment.mvvm.arch

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val failure: Failure) : Result<T>()
}