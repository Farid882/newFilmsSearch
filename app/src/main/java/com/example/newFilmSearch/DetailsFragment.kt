package com.example.myapplication

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.newFilmSearch.Film

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)
        _binding = binding
        setFilmsDetails()
        details_fab_favorites()
        details_share_favorite()
        return binding.root
    }

    private fun details_fab_favorites() {
        binding.detailsFabFavorites.setOnClickListener {
            with(binding) {
                if (!film.isInFavorites) {
                    detailsFabFavorites.setImageResource(R.drawable.baseline_favorite_24)
                    film.isInFavorites = true
                } else {
                    detailsFabFavorites.setImageResource(R.drawable.baseline_favorite_24)
                    film.isInFavorites = false
                }
            }
        }
    }




    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = getArguments()?.get("film") as Film


        //Устанавливаем заголовок и описание фильма
        binding.detailsToolbar.title = film.title

        binding.toolbarLayout.title = film.title
        binding.detailsDescription.text = film.description
        binding.detailsPoster.setImageResource(film.poster)
        binding.detailsToolbar.title = film.title

    }
    private fun details_share_favorite(){
        binding.detailssharefavorite.setOnClickListener {
            val film = getArguments()?.get("film") as Film
            //Создаем интент
            val intent = Intent()
            //Указываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film.title} \n\n ${film.description}"
            )
            //Указываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }
    private fun shareFilm() {
        //Создаем интент
        val intent = Intent()
        //Указываем action с которым он запускается
        intent.action = Intent.ACTION_SEND
        //Кладем данные о нашем фильме
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Check out this film: ${film.title} \n\n ${film.description}"
        )
        //Указываем MIME тип, чтобы система знала, какое приложения предложить
        intent.type = "text/plain"
        //Запускаем наше активити
        startActivity(Intent.createChooser(intent, "Share To:"))
    }
}
