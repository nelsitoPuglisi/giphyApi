package com.nelsito.giphyapi.infrastructure

import com.nelsito.giphyapi.GiphyRepository
import com.nelsito.giphyapi.SearchResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GiphyNetwork: GiphyRepository {
    private suspend fun get(term: String): SearchResponse {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(GiphyClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val client = retrofit.create(GiphyClient::class.java)

        return client.search("I0B54UQCM9Q49V5uzWQC6W0TYyOZ8hb8", term, 10)
    }

    override suspend fun search(query: String): SearchResponse {
        return get(query)
    }
}