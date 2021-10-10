package com.amirovdev.moviesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amirovdev.moviesearch.R
import com.amirovdev.moviesearch.model.Film
import kotlinx.android.synthetic.main.film_item.view.*

// pass the listener so we can process the clicks from the Activity class
class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // the list of the elements from the RecyclerView
    private val items = mutableListOf<Film>()

    // returns the size of the RecyclerView
    override fun getItemCount() = items.size

    // returns the ViewHolder with the 'film_item.xml' layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false))
    }

    // connect the fields from the Film object to the View(film_item.xml)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        // check what ViewHolder we got
        when (holder) {
            is FilmViewHolder -> {

                // call the 'bind' method from the FilmViewHolder and
                // pass the object from the filmsDataBase at a certain position
                holder.bind(items[position])

                // process the click on the whole item and call the method of the listener
                // that we get from the constructor of the Adapter
                holder.itemView.item_container.setOnClickListener {
                    clickListener.click(items[position])
                }
            }
        }
    }

    // add objects to the list
    fun addItems(list: List<Film>) {
        items.clear() // clear the current list
        items.addAll(list) // add the input list
        notifyDataSetChanged() // notify the RecyclerView about the changes
    }

    // the interface to process clicks
    interface OnItemClickListener {
        fun click(film: Film)
    }
}