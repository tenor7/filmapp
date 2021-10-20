package com.example.filmapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.filmapp.Domain.Model.Film;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "film")
public class FilmDTO extends Film {
    @PrimaryKey
    @NotNull
    @ColumnInfo
    public int id;
}