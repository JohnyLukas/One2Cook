package com.example.one2cook.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hit(
    @Json(name = "recipe")
    val recipe: Recipe?
)