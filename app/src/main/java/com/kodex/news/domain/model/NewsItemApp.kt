package com.kodex.news.domain.model

import kotlinx.datetime.LocalDateTime

data class NewsItemApp(
    val id: String,
    val title: String,
    val description: String,
    val publishedBy: String,
    val publishedAt: LocalDateTime,
    val imageUrl: String,
    val isFavorite: Boolean,
)
