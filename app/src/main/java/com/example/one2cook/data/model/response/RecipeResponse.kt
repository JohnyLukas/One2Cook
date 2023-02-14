package com.example.one2cook.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeResponse(
    @Json(name = "hits")
    val recipes: List<Hit>
)