package com.example.filmapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.filmapp.Presentation.Repository.Model.FilmDTO;
import com.example.filmapp.Presentation.Repository.Repository;

public class AddFilmViewModel extends ViewModel {

    public void AddFilm(String name,
                         String genre,
                         String time,
                         String description){

        FilmDTO film = new FilmDTO();
        film.setName(name);
        film.setGenre(genre);
        film.setTime(time);
        film.setDescription(description);

        Repository.getRepository().addFilm(film);
    }
}