package com.example.one2cook.presentation.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class NextUI(
    @Json(name = "href")
    val nextPageUrl: String?
) : Parcelable