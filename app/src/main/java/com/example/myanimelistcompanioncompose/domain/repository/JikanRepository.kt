package com.example.myanimelistcompanioncompose.domain.repository

import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.Data
import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.JikanResponse
import com.example.myanimelistcompanioncompose.util.Resource

interface JikanRepository {

    suspend fun getTopAnimeList(
        filter: String,
        type: String,
        page: Int,
    ): Resource<JikanResponse>

    suspend fun getAnimeByName(): Resource<JikanResponse>
}

