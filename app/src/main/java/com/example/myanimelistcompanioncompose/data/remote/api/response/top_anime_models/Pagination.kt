package com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models

data class Pagination(
    val current_page: Int,
    val has_next_page: Boolean,
    val items: Items,
    val last_visible_page: Int
)