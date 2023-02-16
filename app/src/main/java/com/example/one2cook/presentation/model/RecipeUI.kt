package com.example.one2cook.presentation.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeUI(
    @Json(name = "label")
    val titleRecipe: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "source")
    val sourceRecipe: String,
    @Json(name = "url")
    val urlSource: String,
    @Json(name = "calories")
    val calories: Double,
    @Json(name = "cuisineType")
    val cuisineType: List<String>,
    @Json(name = "ingredientLines")
    val ingredients: List<String>,
    @Json(name = "totalTime")
    val totalTime: Double
)