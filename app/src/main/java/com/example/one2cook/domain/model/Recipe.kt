package com.example.one2cook.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Recipe(
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
    @Json(name = "ingredientLines")
    val ingredients: List<String>,
    @Json(name = "totalTime")
    val totalTime: Double,
    @Json(name = "yield")
    val yield: Int
) : Parcelable