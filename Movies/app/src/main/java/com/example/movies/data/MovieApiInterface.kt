package com.example.movies.data

import MovieResponse
import com.example.movies.model.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=5b2ce55d1f51bb12a7eef170b626eb71")
    fun getMovieList(): Call<MovieResponse>

    @GET("/3/movie/{movie_id}?api_key=5b2ce55d1f51bb12a7eef170b626eb71")
    fun getMovieDetails(@Path("movie_id")id: String): Call<MovieDetails>

}