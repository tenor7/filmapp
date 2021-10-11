package com.example.filmapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.filmapp.Domain.Model.Film;
import com.example.filmapp.Domain.Model.Person;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "film")
public class FilmDTO extends Film {
    @PrimaryKey
    @NotNull
    @ColumnInfo
    public int id;
    @ColumnInfo
    public String FilmList;


    @Override
    public List<Person> getFilmList() {
        return new Gson().fromJson(this.FilmList, List.class);
    }
    @Override
    public void setFilmList(List<Person> filmList) {
        super.setFilmList(filmList);
        this.FilmList = new Gson().toJson(filmList);
    }
}
