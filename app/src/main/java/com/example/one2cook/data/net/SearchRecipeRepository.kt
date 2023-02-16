package com.example.one2cook.data.net

import com.example.one2cook.data.model.toDomain
import com.example.one2cook.domain.model.Recipes
import javax.inject.Inject

class SearchRecipeRepository @Inject constructor(
    private val searchRecipeApi: SearchRecipeApi
) {
    suspend fun searchRecipe(query: String): Recipes =
        searchRecipeApi.searchRecipes(query).toDomain()
}