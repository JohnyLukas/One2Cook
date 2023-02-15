package com.example.one2cook.data.net

import com.example.one2cook.data.model.response.HitResponse
import javax.inject.Inject

class SearchRecipeRepository @Inject constructor(
    private val searchRecipeApi: SearchRecipeApi
) {
    suspend fun searchRecipe(query: String): List<HitResponse>? =
        searchRecipeApi.searchRecipes(query).recipes
}