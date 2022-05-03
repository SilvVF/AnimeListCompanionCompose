package com.example.myanimelistcompanioncompose.data.remote.repository

import com.example.myanimelistcompanioncompose.data.remote.api.JikanApi
import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.Data
import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.JikanResponse
import com.example.myanimelistcompanioncompose.domain.repository.JikanRepository
import com.example.myanimelistcompanioncompose.util.Resource
import javax.inject.Inject


class JikanRepositoryImpl @Inject constructor(
    private val api: JikanApi
): JikanRepository {

    override suspend fun getTopAnimeList(
        filter: String,
        type: String,
        page: Int
    ): Resource<JikanResponse> {
        val response = try {
            api.getTopAnimeList(filter, type, page)
        } catch (e : Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    override suspend fun getAnimeByName(): Resource<JikanResponse> {
        TODO("Not yet implemented")
    }

}