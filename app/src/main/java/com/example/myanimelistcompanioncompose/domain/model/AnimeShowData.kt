package com.example.myanimelistcompanioncompose.domain.model

import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.*

data class AnimeShowData(
    val images: Images?,
    val mal_id: Int?,
    val title: String?,
    val title_english: String?,
    val title_japanese: String?,
    val type: String?,
    val url: String?,
)
