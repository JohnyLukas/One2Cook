package com.example.one2cook.data.network

import com.example.one2cook.data.model.response.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRecipeApi {
    @GET("recipes/v2")
    suspend fun searchRecipes(@Query("q") query: String): RecipesResponse

    @GET("recipes/v2")
    suspend fun nextRecipesPage(
        @Query("q") query: String,
        @Query("_cont") paginationParam: String?
    ): RecipesResponse
}