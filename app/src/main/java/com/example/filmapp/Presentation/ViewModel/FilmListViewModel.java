package com.example.filmapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.filmapp.Domain.Model.Film;
import com.example.filmapp.Presentation.Repository.Repository;

import java.util.List;

public class FilmListViewModel extends ViewModel {

    public LiveData<List<Film>> getFilmList() {
        return Repository.getRepository().getAllFilms();
    }

    public void deleteFilm(Film film) {
        Repository.getRepository().deleteFilm(film);
    }
}