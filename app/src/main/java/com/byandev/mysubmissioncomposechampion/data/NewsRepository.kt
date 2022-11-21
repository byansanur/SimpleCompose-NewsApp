package com.byandev.mysubmissioncomposechampion.data

import com.byandev.mysubmissioncomposechampion.model.Articles
import com.byandev.mysubmissioncomposechampion.model.ArticlesData

class NewsRepository {
    fun getNews() : List<Articles> {
        return ArticlesData.articleList
    }
}