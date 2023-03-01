package com.example.one2cook.data.database

import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
import com.example.one2cook.data.model.toDomain
import com.example.one2cook.domain.model.FavoritesRecipe
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val recipesDao: RecipesDao
) {
    fun getRecipes(): List<FavoritesRecipe> =
        recipesDao.getRecipes().map { it.toDomain() }

    suspend fun addRecipe(favoritesRecipeEntity: FavoritesRecipeEntity) =
        recipesDao.addRecipe(favoritesRecipeEntity)
}