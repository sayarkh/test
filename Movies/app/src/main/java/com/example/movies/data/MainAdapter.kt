package com.example.movies.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.RecyclerViewItemClickListener
import com.example.movies.IMAGE_BASE
import com.example.movies.R
import com.example.movies.model.Movie
import kotlinx.android.synthetic.main.card_layout.view.*

class MainAdapter(
    private val movies: List<Movie>,
    private val onClickListener: RecyclerViewItemClickListener,
): RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MovieViewHolder(v)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindMovie(movie: Movie) {
            itemView.relativeLayout.setOnClickListener {
                onClickListener.onClickListener(movie, position)
            }
            itemView.item_title.text = movie.title
            itemView.item_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.item_img)
        }
    }

}