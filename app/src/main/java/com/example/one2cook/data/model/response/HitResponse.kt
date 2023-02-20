package com.example.one2cook.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class HitResponse(
    @Json(name = "recipe")
    val recipeResponse: RecipeResponse? = null
) : Parcelable