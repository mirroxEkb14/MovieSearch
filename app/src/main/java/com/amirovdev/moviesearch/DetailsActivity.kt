package com.amirovdev.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirovdev.moviesearch.model.Film
import kotlinx.android.synthetic.main.activity_details.*

/**
 * Show film details
 */

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // get the film from the Bundle
        val film = intent.extras?.get("film") as Film
        initView(film)
    }

    private fun initView(film: Film) {
        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.desc
    }
}