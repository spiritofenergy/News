package com.kodex.news.presentation.screen.main.feed

import com.kodex.news.domain.model.NewsItemApp

sealed interface FeedScreenEvent {
    data class SearchQueryChanged(val newSearchQuery: String): FeedScreenEvent
    data class NewsItemClicked(val newsItemApp: NewsItemApp): FeedScreenEvent
    data class NewsItemFavoriteToggleClicked(val newsItemApp: NewsItemApp): FeedScreenEvent

}