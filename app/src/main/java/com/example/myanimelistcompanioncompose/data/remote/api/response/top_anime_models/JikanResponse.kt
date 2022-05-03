package com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models

data class JikanResponse(
    val `data`: List<Data>,
    val links: Links,
    val meta: Meta,
    val pagination: Pagination
)