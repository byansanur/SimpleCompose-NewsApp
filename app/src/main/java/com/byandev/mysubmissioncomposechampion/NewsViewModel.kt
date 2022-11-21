package com.byandev.mysubmissioncomposechampion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.byandev.mysubmissioncomposechampion.data.NewsRepository
import com.byandev.mysubmissioncomposechampion.model.Articles
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
    private val _getListNews = MutableStateFlow(
        repository.getNews()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )
    val getListNews: StateFlow<Map<Char, List<Articles>>> get() = _getListNews
}

class ViewModelFactory(private val repository: NewsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}