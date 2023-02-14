package com.example.one2cook.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Recipes(
    @Json(name = "hits")
    val recipes: List<Hit>?
)