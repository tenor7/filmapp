package com.example.filmapp.Presentation.Repository.Mock;

import androidx.lifecycle.MutableLiveData;

import com.example.filmapp.Domain.Model.Film;
import com.example.filmapp.Presentation.Repository.RepositoryTasks;

import java.util.List;

public class MockBase implements RepositoryTasks {
    MutableLiveData<List<Film>> data;
    List<Film> list;

    public MutableLiveData<List<Film>> getAllFilms() {
        return data;
    }

    public MockBase() {
        Film film1 = new Film();
        film1.setName("Matrix");
        film1.setTime("123");
        film1.setGenre("film");
        list.add(film1);

        Film film2 = new Film();
        film2.setName("Matrix");
        film2.setTime("123");
        film2.setGenre("film");
        list.add(film2);

        Film film3 = new Film();
        film3.setName("Matrix");
        film3.setTime("123");
        film3.setGenre("film");
        list.add(film3);

        Film film4 = new Film();
        film4.setName("Matrix");
        film4.setTime("123");
        film4.setGenre("film");
        list.add(film4);

        Film film5 = new Film();
        film5.setName("Matrix");
        film5.setTime("123");
        film5.setGenre("film");
        list.add(film5);

        data = new MutableLiveData<>(list);
    }

    public <T extends Film> void addFilm(T film) {
        list.add(film);

        data.setValue(list);
    }

    @Override
    public <T extends Film> void deleteFilm(T film) {
        list.remove(film);

        data.setValue(list);
    }
}
