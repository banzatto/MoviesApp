package com.example.moviesapp.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.example.moviesapp.data.database.entity.MovieEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int? = null,
    var backdrop_path: String? = null,
    val overview: String? = null,
    var poster_path: String? = null,
    val title: String? = null,

    ) : Parcelable {

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Movie> =
            object : DiffUtil.ItemCallback<Movie>() {
                override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}

fun toEntity(movie: Movie): MovieEntity {
    return MovieEntity(
        id = movie.id,
        title = movie.title,
        poster_path = movie.poster_path,
        overview = movie.overview,
        backdrop_path = movie.backdrop_path
        )
}
