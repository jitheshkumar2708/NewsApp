package com.assignment.mvvm.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @Embedded
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val thumbnailUrl: String?,
    val publishedAt: String?,
    val content: String?
)

data class Source(
    val sourceId: String?,
    val sourceName: String?
)