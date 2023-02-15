package com.example.one2cook.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeResponse(
    @Json(name = "label")
    val titleRecipe: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "source")
    val sourceRecipe: String? = null,
    @Json(name = "url")
    val urlSource: String? = null,
    @Json(name = "calories")
    val calories: Double? = null,
    @Json(name = "cuisineType")
    val cuisineType: List<String>? = null,
    @Json(name = "ingredientLines")
    val ingredients: List<String>? = null,
    @Json(name = "totalTime")
    val totalTime: Double? = null
)