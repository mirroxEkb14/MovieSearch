package com.amirovdev.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amirovdev.moviesearch.model.Film
import kotlinx.android.synthetic.main.fragment_details.*

/**
 * Show film details
 */

class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // get the film from the Bundle
        val film = arguments?.get("film") as Film
        initView(film)
    }

    private fun initView(film: Film) {
        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.desc
    }
}