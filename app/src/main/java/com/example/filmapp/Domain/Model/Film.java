package com.example.filmapp.Domain.Model;

import java.util.Arrays;
import java.util.List;

public class Film {
    public String name;
    public String description;
    public String genre;
    public String time;

    public Film(String name, String description, String genre, String time) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.time = time;
    }

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
