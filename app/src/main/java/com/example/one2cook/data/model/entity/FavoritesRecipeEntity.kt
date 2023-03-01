package com.example.one2cook.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class FavoritesRecipeEntity(
    @PrimaryKey
    val id: UUID,
    val titleRecipe: String,
    val image: String,
    val sourceRecipe: String,
    val urlSource: String,
    val calories: Double,
    val ingredients: List<String>,
    val totalTime: Double,
    val yield: Int
)