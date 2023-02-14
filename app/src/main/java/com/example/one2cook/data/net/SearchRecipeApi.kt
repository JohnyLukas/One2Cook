package com.example.one2cook.data.net

import com.example.one2cook.data.model.response.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRecipeApi {
    @GET("?type=public")
    suspend fun searchRecipes(@Query("q") query: String): RecipesResponse
}