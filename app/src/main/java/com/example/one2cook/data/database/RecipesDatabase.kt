package com.example.one2cook.data.database

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.one2cook.data.model.entity.FavoritesRecipeEntity

@androidx.room.Database(entities = [FavoritesRecipeEntity::class], version = 1)
@TypeConverters(ListTypeConverter::class)
abstract class RecipesDatabase: RoomDatabase() {
    abstract fun getRecipesDao(): RecipesDao
}