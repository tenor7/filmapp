package com.example.filmapp.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.filmapp.Presentation.Repository.Model.FilmDTO;

import java.util.List;

@Dao
public interface FilmDAO {
    @Insert
    void addFilm(FilmDTO film);

    @Delete
    void deleteFilm(FilmDTO film);

    @Query("SELECT * FROM film")
    LiveData<List<FilmDTO>> getAllFilms();
}
