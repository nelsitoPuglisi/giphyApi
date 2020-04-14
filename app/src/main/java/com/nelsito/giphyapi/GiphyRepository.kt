package com.nelsito.giphyapi

interface GiphyRepository {
    suspend fun search(query: String): SearchResponse
}
