package mgareta.themoviedb.data.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by marc on 16/03/18.
 */

class ResultMovie {

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int? = null

    @SerializedName("id")
    @Expose
    val id: Int? = null

    @SerializedName("video")
    @Expose
    val video: Boolean? = null

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("popularity")
    @Expose
    val popularity: Double? = null

    @SerializedName("poster_path")
    @Expose
    val posterPath: String? = null

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    val originalTitle: String? = null

    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Int>? = null

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String? = null

    @SerializedName("adult")
    @Expose
    val adult: Boolean? = null

    @SerializedName("overview")
    @Expose
    val overview: String? = null

    @SerializedName("release_date")
    @Expose
    val releaseDate: String? = null
}