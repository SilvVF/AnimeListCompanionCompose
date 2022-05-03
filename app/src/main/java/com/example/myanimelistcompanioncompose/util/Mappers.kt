package com.example.myanimelistcompanioncompose.util

import com.example.myanimelistcompanioncompose.domain.model.AnimeShowData
import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.Data

/**
 * contains object to object mappings when going from data entities into
 * domain layer objects
 */

fun Data.toAnimeShowData(): AnimeShowData {
    return AnimeShowData(
        images = this.images,
        mal_id = this.mal_id,
        title = this.title,
        title_english = this.title_english,
        title_japanese = this.title_japanese,
        type = this.type,
        url = this.url
    )
}