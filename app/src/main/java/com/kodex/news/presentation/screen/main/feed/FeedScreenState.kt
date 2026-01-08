package com.kodex.news.presentation.screen.main.feed

import com.kodex.news.domain.model.NewsItemApp

data class FeedScreenState(
    val searchQuery: String = "",
    val filteredNews: List<NewsItemApp> = emptyList(),
)
