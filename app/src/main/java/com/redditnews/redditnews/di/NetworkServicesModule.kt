package com.redditnews.redditnews.di



import com.redditnews.data.modules.articles.remote.ArticlesServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

    @Provides
    @Singleton
    fun provideArticlesService(retrofit: Retrofit): ArticlesServices =
        retrofit.create(ArticlesServices::class.java)

}