package com.nelsito.giphyapi.infrastructure

import com.nelsito.giphyapi.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyClient {

    @GET("search")
    suspend fun search(@Query("api_key") apiKey: String, @Query("q") term: String, @Query("limit") limit: Int) : SearchResponse

    companion object {
        const val BASE_URL = "https://api.giphy.com/v1/gifs/"
    }
}