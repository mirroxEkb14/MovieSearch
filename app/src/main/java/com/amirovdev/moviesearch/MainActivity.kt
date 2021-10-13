package com.amirovdev.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.amirovdev.moviesearch.model.Film
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var backPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        top_toolbar.setOnMenuItemClickListener { onTopToolbarClicked(it) }
        bottom_navigation.setOnNavigationItemSelectedListener { onBottomNavigationClicked(it) }

        // launch the fragment when starting
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()
    }

    fun launchDetailsFragment(film: Film) {
        // create a 'parcel' (to pass the data)
        val bundle = Bundle()
        // put the Film in the 'parcel'
        bundle.putParcelable("film", film)
        // put the fragment with details in the variable
        val fragment = DetailsFragment()
        // attach our 'parcel' to the fragment
        fragment.arguments = bundle

        // launch the fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

//    private fun onTopToolbarClicked(menuItem: MenuItem): Boolean {
//        return when (menuItem.itemId) {
//            R.id.settings -> {
//                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
//                true
//            }
//            else -> false
//        }
//    }

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

    // double tap for exit the app
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed()
                finish()
            } else {
                Toast.makeText(this, "Double tap for exit", Toast.LENGTH_SHORT).show()
            }
            backPressed = System.currentTimeMillis()

        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val TIME_INTERVAL = 2000
    }
}