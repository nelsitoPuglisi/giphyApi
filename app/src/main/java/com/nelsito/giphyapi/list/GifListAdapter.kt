package com.nelsito.giphyapi.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nelsito.giphyapi.R
import kotlinx.android.synthetic.main.list_item.view.*

class GifListAdapter(private val context: Context): ListAdapter<GifListItem, RecyclerView.ViewHolder>(
    GifDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GifViewHolder(
            inflater.inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GifViewHolder).bind(getItem(position) as GifListItem, context)
    }

    private class GifViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(gifListItem: GifListItem, context: Context) {
            Glide.with(context)
                .load(gifListItem.url)
                .into(itemView.img_gif)
                .clearOnDetach()
        }
    }
}