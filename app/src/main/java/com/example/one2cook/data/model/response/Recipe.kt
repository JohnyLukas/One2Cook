package com.example.one2cook.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Recipe(
    @Json(name = "label")
    val titleRecipe: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "images")
    val images: Images,
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