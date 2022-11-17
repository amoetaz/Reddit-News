package com.redditnews.redditnews.di



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

   /* @Provides
    @Singleton
    fun provideAuthService(@Named("main_retrofit")retrofit: Retrofit): AuthServices =
        retrofit.create(AuthServices::class.java)

    @Provides
    @Singleton
    fun provideGeneralService(@Named("main_retrofit")retrofit: Retrofit): GeneralServices =
        retrofit.create(GeneralServices::class.java)*/

}