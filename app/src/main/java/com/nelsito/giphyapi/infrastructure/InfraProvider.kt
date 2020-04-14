package com.nelsito.giphyapi.infrastructure

import com.nelsito.giphyapi.GiphyRepository

class InfraProvider {
    companion object Provider {
        private val repository =
            GiphyNetwork()

        fun provideGiphyRepository(): GiphyRepository {
            return repository
        }
    }
}