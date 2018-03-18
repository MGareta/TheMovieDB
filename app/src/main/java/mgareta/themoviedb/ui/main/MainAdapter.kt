package mgareta.themoviedb.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import mgareta.themoviedb.BuildConfig
import mgareta.themoviedb.R
import mgareta.themoviedb.data.rest.model.ResultMovie

/**
 * Created by marc on 17/03/18.
 */

class MainAdapter<in T> : RecyclerView.Adapter<MainAdapter.MainMovieViewHolder>() {

    private var movieList: ArrayList<ResultMovie> = ArrayList()

    fun setMovieList(movieList: ArrayList<ResultMovie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    fun addMovieList(movieList: ArrayList<ResultMovie>) {
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return MainMovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainMovieViewHolder, position: Int) {
        val resultMovie = movieList[position]

        holder.textViewTitle.text = resultMovie.title
        holder.textViewReleaseDate.text = resultMovie.releaseDate
        holder.textViewOverview.text = resultMovie.overview

        Glide.with(holder.itemView.context)
                .load(BuildConfig.IMAGE_PREFIX + resultMovie.posterPath)
                .into(holder.imageViewPoster)
    }

    class MainMovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageViewPoster: ImageView = itemView.findViewById<ImageView>(R.id.image_view_poster)

        val textViewTitle: TextView = itemView.findViewById<TextView>(R.id.text_view_title)
        val textViewReleaseDate: TextView = itemView.findViewById<TextView>(R.id.text_view_release_date)
        val textViewOverview: TextView = itemView.findViewById<TextView>(R.id.text_view_overview)
    }
}