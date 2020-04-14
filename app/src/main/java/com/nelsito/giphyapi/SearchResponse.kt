package com.nelsito.giphyapi

data class SearchResponse(val data: List<GiphyObject>, val pagination: GiphyPagination, val meta: GiphyMeta)

data class GiphyPagination(val offset: Int, val count: Int, val totalCount: Int)

data class GiphyMeta(val responseId: String, val message: String, val status: Int)

data class GiphyObject(val id: String, val url: String, val images: GiphyImages)

data class GiphyImages(val downsized_large: GiphyImage)

data class GiphyImage(val url: String)


