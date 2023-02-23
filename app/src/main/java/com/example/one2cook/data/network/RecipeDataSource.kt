package com.example.one2cook.data.network

import com.example.one2cook.data.model.toDomain
import com.example.one2cook.domain.model.Recipes
import javax.inject.Inject

class RecipeDataSource @Inject constructor(
    private val searchRecipeApi: SearchRecipeApi
) {
    suspend fun searchRecipe(query: String): Recipes =
        searchRecipeApi.searchRecipes(query).toDomain()

    suspend fun nextRecipesPage(query: String, cont: String): Recipes =
        searchRecipeApi.nextRecipesPage(
            query = query,
            cont = cont
        ).toDomain()

}