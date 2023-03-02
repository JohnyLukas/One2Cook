package com.example.one2cook.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.one2cook.data.model.entity.FavoritesRecipeEntity

@Dao
interface RecipesDao {
    @Query("SELECT * FROM favoritesRecipeEntity")
    suspend fun getRecipes(): List<FavoritesRecipeEntity>

    @Insert
    suspend fun addRecipe(favoritesRecipeEntity: FavoritesRecipeEntity)

    @Delete
    suspend fun deleteRecipe(favoritesRecipeEntity: FavoritesRecipeEntity)
}