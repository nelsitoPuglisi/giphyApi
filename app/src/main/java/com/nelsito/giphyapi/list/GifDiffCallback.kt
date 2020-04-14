package com.nelsito.giphyapi.list

import androidx.recyclerview.widget.DiffUtil

class GifDiffCallback : DiffUtil.ItemCallback<GifListItem>(){
    override fun areItemsTheSame(oldItem: GifListItem, newItem: GifListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GifListItem, newItem: GifListItem): Boolean {
        return oldItem == newItem
    }
}
