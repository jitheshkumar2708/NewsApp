package com.assignment.mvvm.data.mapper

interface Mapper<in S, T> {
    fun transform(model: S): T
    fun transform(models: List<S>): List<T>
}
