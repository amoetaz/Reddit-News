package com.redditnews.domain.modules.articles.useCases

import com.redditnews.domain.modules.articles.repository.ArticlesRepository
import com.redditnews.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val articlesRepository: ArticlesRepository) {


    operator fun invoke() = flow{
        emit(Resource.Loading)

        emit(articlesRepository.getArticles())
    }.flowOn(Dispatchers.IO)
}