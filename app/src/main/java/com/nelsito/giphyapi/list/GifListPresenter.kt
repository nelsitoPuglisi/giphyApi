package com.nelsito.giphyapi.list

import com.nelsito.giphyapi.GiphyRepository

class GifListPresenter(private val userListView: UserListView, private val giphyRepository: GiphyRepository) {
    suspend fun loadGifs(query: String) {
        val list = giphyRepository.search(query).data.map {
            GifListItem(it.images.downsized_large.url)
        }
        userListView.showGifs(list)
    }
}

interface UserListView {
    fun showGifs(list: List<GifListItem>)
}
