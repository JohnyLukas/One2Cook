package com.example.one2cook.data.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity
@Parcelize
data class FavoritesRecipeEntity(
    @PrimaryKey
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