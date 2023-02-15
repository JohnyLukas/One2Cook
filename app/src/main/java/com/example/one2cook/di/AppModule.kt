package com.example.one2cook.di

import com.example.one2cook.BuildConfig
import com.example.one2cook.data.net.SearchRecipeApi
import com.example.one2cook.data.net.SearchRecipeInterceptor
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
    fun provideRecipesInterceptor() = SearchRecipeInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(searchRecipeInterceptor: SearchRecipeInterceptor) = OkHttpClient.Builder()
        .addInterceptor(searchRecipeInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory() = MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): SearchRecipeApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .client(okHttpClient)
        .build()
        .create(SearchRecipeApi::class.java)
}