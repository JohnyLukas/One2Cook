package com.example.one2cook.data.net

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("?type=public")
    suspend fun searchRecipes(@Query("q") query: String)
}