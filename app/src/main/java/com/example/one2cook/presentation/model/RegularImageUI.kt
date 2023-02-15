package com.example.one2cook.presentation.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegularImageUI(
    @Json(name = "height")
    val height: Int,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: Int
)