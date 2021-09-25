package com.amirovdev.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topToolbar.setOnMenuItemClickListener { onTopToolbarClicked(it) }
        bottomNavigation.setOnNavigationItemSelectedListener { onBottomNavigationClicked(it) }

        btnDarkMode.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun onTopToolbarClicked(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }

    private fun onBottomNavigationClicked(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.selections -> {
                Toast.makeText(this, "Selections", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.watch_later -> {
                Toast.makeText(this, "Watch Later", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.favorites -> {
                Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}