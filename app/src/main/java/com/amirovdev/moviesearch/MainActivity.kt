package com.amirovdev.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // buttons from 'main_activity'
    private lateinit var btnMenu: Button
    private lateinit var btnFavorites: Button
    private lateinit var btnSeeLater: Button
    private lateinit var btnSelections: Button
    private lateinit var btnSettings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnMenu.setOnClickListener {
            Toast.makeText(this, "Menu!", Toast.LENGTH_SHORT).show()
        }

        btnFavorites.setOnClickListener {
            Toast.makeText(this, "Favorites!", Toast.LENGTH_SHORT).show()
        }

        btnSeeLater.setOnClickListener {
            Toast.makeText(this, "See Later!", Toast.LENGTH_SHORT).show()
        }
        btnSelections.setOnClickListener {
            Toast.makeText(this, "Selections!", Toast.LENGTH_SHORT).show()
        }

        btnSettings.setOnClickListener {
            Toast.makeText(this, "Settings!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView() {
        btnMenu = findViewById(R.id.btn_menu)
        btnFavorites = findViewById(R.id.btn_favorites)
        btnSeeLater = findViewById(R.id.btn_see_later)
        btnSelections = findViewById(R.id.btn_selections)
        btnSettings = findViewById(R.id.btn_settings)
    }
}