package com.example.one2cook.data.net

import com.example.one2cook.data.model.response.Hit
import javax.inject.Inject

class SearchRecipeRepository @Inject constructor(
    private val searchRecipeApi: SearchRecipeApi
) {
    suspend fun searchRecipe(query: String): List<Hit> =
        searchRecipeApi.searchRecipes(query).recipes
}