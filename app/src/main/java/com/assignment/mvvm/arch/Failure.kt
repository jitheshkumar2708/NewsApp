package com.assignment.mvvm.arch

data class Failure(
    val code: Int?,
    val message: String,
    val exception: Exception? = null
)