package com.redditnews.data.modules.articles.repository



import com.redditnews.data.models.toArticle
import com.redditnews.data.models.toDataResource
import com.redditnews.data.modules.articles.remote.ArticlesRemoteDataSource
import com.redditnews.domain.models.Article
import com.redditnews.domain.modules.articles.repository.ArticlesRepository
import com.redditnews.domain.utils.Resource

import javax.inject.Inject

class ArticlesRepositoryImp @Inject constructor(private val articlesRemoteDataSource: ArticlesRemoteDataSource) :
    ArticlesRepository {

    override suspend fun getArticles(): Resource<List<Article>?> {
        val resource = articlesRemoteDataSource.getArticles()
        return if (resource is Resource.Success)
            Resource.Success(resource.value?.data?.children?.map { it.data?.toArticle()!! })
        else resource.toDataResource()
    }


}