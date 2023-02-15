package com.example.one2cook.presentation.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HitUI(
    @Json(name = "recipe")
    val recipeUI: RecipeUI
)