package com.example.newFilmSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DetailsFragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R


class HomeFragment : Fragment() {
    private lateinit var mainrecycler: RecyclerView
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val film: Film? = null
    val filmsDataBase = listOf(
        Film(
            "The Shawshank Redemption",
            R.drawable.shawshank,
            "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "The Godfather",
            R.drawable.god_father,
            "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "The Dark Knight",
            R.drawable.dark_knight,
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "Pulp Fiction",
            R.drawable.pulp,
            "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "Inception",
            R.drawable.inception,
            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "Hamilton",
            R.drawable.hamilton,
            "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "Gisaengchung",
            R.drawable.parasites,
            "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "Interstellar",
            R.drawable.interstellar,
            "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "Joker",
            R.drawable.joker,
            "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
            R.drawable.ic_launcher_foreground
        ),
        Film(
            "1917",
            R.drawable.seventy,
            "April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap.",
            R.drawable.ic_launcher_foreground
        )

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainrecycler = view.findViewById(R.id.main_recycler)

        //находим наш RV
         mainrecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                            //(requireActivity() as MainActivity).launchDetailsFragment(film)
                        val fragment = DetailsFragment()
                        val bundle = Bundle()
                        bundle.putParcelable("film", film)
                        fragment.arguments = bundle
                        (requireActivity() as MainActivity).supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .addToBackStack(null)
                            .commit()
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(context)
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)
    }

}