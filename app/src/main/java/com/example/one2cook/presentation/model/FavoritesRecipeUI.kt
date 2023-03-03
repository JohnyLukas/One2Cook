package com.example.one2cook.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class FavoritesRecipeUI(
    val id: UUID,
    val isFavorites: Boolean,
    val titleRecipe: String,
    val image: String,
    val sourceRecipe: String,
    val urlSource: String,
    val calories: Double,
    val ingredients: List<String>,
    val totalTime: Double,
    val yield: Int
) : Parcelable
