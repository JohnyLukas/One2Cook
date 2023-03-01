package com.example.one2cook.domain.model

import java.util.*

data class FavoritesRecipe(
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
