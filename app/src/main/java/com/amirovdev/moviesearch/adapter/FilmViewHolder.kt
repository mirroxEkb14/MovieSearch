package com.amirovdev.moviesearch.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.moviesearch.model.Film
import kotlinx.android.synthetic.main.film_item.view.*

/**
 * Connect the fields from the Film to the View
 *
 * 'itemView' is the layout 'film_item.xml'
 */
class FilmViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    // connect the View from the layout(film_item.xml) to the created fields
    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description

    // put the data from the Film object to the View
    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.desc
    }
}