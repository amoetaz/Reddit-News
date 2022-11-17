package com.redditnews.redditnews.di



import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    /*@Provides
    @Singleton
    fun provideAuthRepository(
        remoteDataSource: AuthRemoteDataSource,
    ): AuthRepository = AuthRepositoryImp(remoteDataSource)

    @Provides
    @Singleton
    fun provideGeneralRepository(
        remoteDataSource: GeneralRemoteDataSource,
        youtubeRemoteDataSource: YoutubeRemoteDataSource,
    ): GeneralRepository = GeneralRepositoryImp(youtubeRemoteDataSource,remoteDataSource)*/

}