package com.nelsito.giphyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.nelsito.giphyapi.infrastructure.InfraProvider
import com.nelsito.giphyapi.list.GifListAdapter
import com.nelsito.giphyapi.list.GifListItem
import com.nelsito.giphyapi.list.GifListPresenter
import com.nelsito.giphyapi.list.UserListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope, UserListView {
    private lateinit var presenter: GifListPresenter
    private lateinit var listAdapter: GifListAdapter
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()

        listAdapter = GifListAdapter(this)
        my_list.adapter = listAdapter

        presenter = GifListPresenter(this, InfraProvider.provideGiphyRepository())
    }

    override fun onResume() {
        super.onResume()
        launch {
            presenter.loadGifs("joker")
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        job.cancel()
    }

    override fun showGifs(list: List<GifListItem>) {
        listAdapter.submitList(list)
        progress.visibility = View.GONE
        my_list.visibility = View.VISIBLE
    }
}
