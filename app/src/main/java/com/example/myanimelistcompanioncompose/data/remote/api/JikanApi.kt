package com.example.myanimelistcompanioncompose.data.remote.api

import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.JikanResponse
import com.example.myanimelistcompanioncompose.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanApi {

    @GET("top/anime")
    suspend fun getTopAnimeList(
        @Query("filter")
        filter: String = "",
        @Query("type")
        type: String = "tv",
        @Query("page")
        page: Int = 1
    ): JikanResponse

    companion object {
        const val BASE_URL = "https://api.jikan.moe/v4/"
        const val PAGE_SIZE = 25
    }
}