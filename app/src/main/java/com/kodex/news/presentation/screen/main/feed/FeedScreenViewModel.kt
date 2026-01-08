package com.kodex.news.presentation.screen.main.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.kodex.news.data.repository.NewsRepository
import com.kodex.news.domain.model.NewsItemApp
import com.kodex.news.presentation.navigation.Screen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel(assistedFactory = FeedScreenViewModel.Factory::class)
class FeedScreenViewModel @AssistedInject constructor(
    @Assisted val navigate: (Screen)-> Unit,
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FeedScreenState())
    val state = _state.asStateFlow()

    private var news: List<NewsItemApp> = emptyList()

    fun onEvent(event: FeedScreenEvent){
        when(event){
            is FeedScreenEvent.NewsItemClicked -> TODO()
            is FeedScreenEvent.SearchQueryChanged -> onSearchQueryChanged(event.newSearchQuery)
            is FeedScreenEvent.NewsItemFavoriteToggleClicked -> onNewsItemFavoriteToggleClicked(event.newsItemApp)

        }
    }

    private fun onNewsItemFavoriteToggleClicked(newsItemApp: NewsItemApp){
        val updatedNews = state.value.filteredNews.map {
            if(it.id == newsItemApp.id) newsItemApp.copy(isFavorite = !newsItemApp.isFavorite)
            else it
        }
        _state.update { it.copy(filteredNews = updatedNews) }
    }

    private fun onSearchQueryChanged(newsQuery: String) {
        _state.update { it.copy(searchQuery = newsQuery) }

        viewModelScope.launch {
            _state.update { it.copy(filteredNews = filterNews(newsQuery, news)) }
        }

    }
        private fun loadNews() = viewModelScope.launch{
            val news = withContext(Dispatchers.IO){newsRepository.loadNews()}
            this@FeedScreenViewModel.news = news
            _state.update { it.copy(filteredNews = filterNews(state.value.searchQuery, news)) }
        }

    private suspend fun filterNews(query: String, news: List<NewsItemApp>): List<NewsItemApp>{
        return withContext(Dispatchers.Default){
            if (query.isEmpty())news
            else news.filter { it.title.contains(query) }
        }
    }
    init {
        loadNews()
    }

    @AssistedFactory
    interface Factory{
        fun create(navigate: (Screen) -> Unit): FeedScreenViewModel
    }
}