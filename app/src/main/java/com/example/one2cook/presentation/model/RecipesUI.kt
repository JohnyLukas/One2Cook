package com.example.one2cook.presentation.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipesUI(
    @Json(name = "hits")
    val recipes: List<HitUI>?
)