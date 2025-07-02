package com.example.myapplication

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater, container, false)
        _binding = binding
        setFilmsDetails()
        // Inflate the layout for this fragment
        return  binding.root
    }


    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film
        binding.detailsToolbar.title = film.title

        binding.toolbarLayout.title = film.title
        binding.detailsDescription.text = film.description
        binding.detailsPoster.setImageResource(film.poster)
        binding.detailsToolbar.title = film.title

    }
}
