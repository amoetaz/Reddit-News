package com.redditnews.domain.modules.articles.repository

import com.redditnews.domain.models.Article
import com.redditnews.domain.utils.Resource

interface ArticlesRepository {

    suspend fun getArticles(): Resource<List<Article>?>
}