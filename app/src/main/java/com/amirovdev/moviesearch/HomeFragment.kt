package com.amirovdev.moviesearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.amirovdev.moviesearch.adapter.FilmListRecyclerAdapter
import com.amirovdev.moviesearch.decoraion.TopSpacingItemDecoration
import com.amirovdev.moviesearch.model.Film
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * The Fragment for the main screen
 */

class HomeFragment : Fragment() {

    // the Adapter for the RecyclerView
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmsDataBase = listOf(
            Film("Interstellar", R.drawable.interstellar, "Interstellar is a 2014 epic science fiction drama film co-written, directed and produced by Christopher Nolan. It stars Matthew McConaughey, Anne Hathaway, Jessica Chastain, Bill Irwin, Ellen Burstyn, and Michael Caine. Set in a dystopian future where humanity is struggling to survive, the film follows a group of astronauts who travel through a wormhole near Saturn in search of a new home for humanity."),
            Film("The Dark Knight", R.drawable.the_dark_knight, "The Dark Knight is a 2008 superhero film directed, produced, and co-written by Christopher Nolan. Based on the DC Comics character Batman, the film is the second installment of Nolan's The Dark Knight Trilogy and a sequel to 2005's Batman Begins, starring Christian Bale and supported by Michael Caine, Heath Ledger, Gary Oldman, Aaron Eckhart, Maggie Gyllenhaal, and Morgan Freeman."),
            Film("The Shawshank Redemption", R.drawable.the_shawshank_redemption, "The Shawshank Redemption is a 1994 American drama film written and directed by Frank Darabont, based on the 1982 Stephen King novella Rita Hayworth and Shawshank Redemption. It tells the story of banker Andy Dufresne (Tim Robbins), who is sentenced to life in Shawshank State Penitentiary for the murders of his wife and her lover, despite his claims of innocence."),
            Film("Inception", R.drawable.inception, "Inception is a 2010 science fiction action film[4][5][6] written and directed by Christopher Nolan, who also produced the film with Emma Thomas, his wife. The film stars Leonardo DiCaprio as a professional thief who steals information by infiltrating the subconscious of his targets. He is offered a chance to have his criminal history erased as payment for the implantation of another person's idea into a target's subconscious."),
            Film("Fight Club", R.drawable.fight_club, "Fight Club is a 1999 American film directed by David Fincher and starring Brad Pitt, Edward Norton, and Helena Bonham Carter. It is based on the 1996 novel of the same name by Chuck Palahniuk. Norton plays the unnamed narrator, who is discontented with his white-collar job. He forms a \"fight club\" with soap salesman Tyler Durden (Pitt), and becomes embroiled in a relationship with a destitute woman, Marla Singer (Bonham Carter)."),
            Film("How to Train Your Dragon: The Hidden World", R.drawable.how_to_train_your_dragon, "How to Train Your Dragon: The Hidden World is a 2019 American computer-animated action fantasy film loosely based on the book series of the same name by Cressida Cowell. Produced by DreamWorks Animation and distributed by Universal Pictures, it is the sequel to How to Train Your Dragon 2 (2014) and the third and final installment in the How to Train Your Dragon trilogy."),
            Film("Top Gun", R.drawable.top_gun, "Top Gun is a 1986 American action drama film directed by Tony Scott, and produced by Don Simpson and Jerry Bruckheimer, in association with Paramount Pictures. The screenplay was written by Jim Cash and Jack Epps Jr., and was inspired by an article titled \"Top Guns\" published in California magazine three years earlier."),
            Film("Coco", R.drawable.coco, "Coco is a 2017 American computer-animated fantasy film produced by Pixar Animation Studios and released by Walt Disney Pictures. Based on an original idea by Lee Unkrich, it is directed by him and co-directed by Adrian Molina. The film's voice cast stars Anthony Gonzalez, Gael García Bernal, Benjamin Bratt, Alanna Ubach, Renée Victor, Ana Ofelia Murguía and Edward James Olmos."),
            Film("Wonder Woman", R.drawable.wonder_woman, "Wonder Woman is a 2017 American superhero film based on the DC Comics character of the same name, produced by DC Films in association with RatPac Entertainment and Chinese company Tencent Pictures and distributed by Warner Bros. Pictures. It is the fourth installment in the DC Extended Universe (DCEU).")
        )
        rvInit(filmsDataBase)
    }

    // initialize the RecyclerView
    private fun rvInit(filmsDataBase: List<Film>) {
        // find the RecyclerView
        main_recycler.apply {

            // initialize the Adapter, the constructor takes the initialized interface
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })

            adapter = filmsAdapter // assign the Adapter
            layoutManager = LinearLayoutManager(requireContext()) // assign the LayoutManager

            // apply the decorator for the indents
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        filmsAdapter.addItems(filmsDataBase) // put the filmsDataBase in the RecyclerView
    }
}