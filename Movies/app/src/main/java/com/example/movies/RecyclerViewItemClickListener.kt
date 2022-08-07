package com.example.movies

import com.example.movies.model.Movie

interface RecyclerViewItemClickListener {
    fun onClickListener(movie: Movie, pos: Int)
}