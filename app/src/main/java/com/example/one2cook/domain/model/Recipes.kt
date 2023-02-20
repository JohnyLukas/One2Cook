package com.example.one2cook.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Recipes(
    @Json(name = "hits")
    val recipes: List<Hits>?
) : Parcelable