package com.example.filmapp.Presentation.Repository;

import androidx.lifecycle.LiveData;

import com.example.filmapp.Domain.Model.Film;

import java.util.List;

public interface RepositoryTasks {
    <T extends Film> LiveData<List<T>> getAllFilms();
    <T extends Film> void addFilm(T film);
    <T extends Film> void deleteFilm(T film);
}
