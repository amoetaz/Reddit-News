package com.redditnews.redditnews.di



import com.redditnews.data.modules.articles.remote.ArticlesRemoteDataSource
import com.redditnews.data.modules.articles.repository.ArticlesRepositoryImp
import com.redditnews.domain.modules.articles.repository.ArticlesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideArticlesRepository(
        remoteDataSource: ArticlesRemoteDataSource
    ): ArticlesRepository = ArticlesRepositoryImp(remoteDataSource)

}