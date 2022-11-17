package com.redditnews.data.models

import com.redditnews.domain.models.Article
import com.redditnews.domain.utils.Resource

fun ArticleDto.toArticle() = Article(
    title = title, thumbnail = media?.oembed?.thumbnailUrl, desc = selftext

)

fun <T, R> Resource<T>.toDataResource(): Resource<R> where R : Any {
    return when (this) {
        is Resource.Failure -> {
            this
        }
        is Resource.Loading -> {
            this
        }
        else -> {
            Resource.Default
        }
    }
}