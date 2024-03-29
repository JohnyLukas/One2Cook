package com.example.one2cook.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class RecipesResponse(
    @Json(name = "hits")
    val recipes: List<HitsResponse>? = null,
    @Json(name = "_links")
    val nextPageLink: LinkResponse? = null
) : Parcelable