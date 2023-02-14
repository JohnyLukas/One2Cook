package com.example.one2cook.di

import com.example.one2cook.BuildConfig
import com.example.one2cook.data.net.ApiService
import com.example.one2cook.data.net.RecipesInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipesInterceptor() = RecipesInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(recipesInterceptor: RecipesInterceptor) = OkHttpClient.Builder()
        .addInterceptor(recipesInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory() = MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): ApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)
}