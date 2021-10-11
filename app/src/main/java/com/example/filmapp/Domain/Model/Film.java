package com.example.filmapp.Domain.Model;

import androidx.lifecycle.LiveData;

import java.util.Arrays;
import java.util.List;

public class Film {
    public String name;
    public String description;
    public String genre;
    public String time;

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    private List<Person> peopleList;

    public Film() {}

    public Film(String name, Person creator, String time) {
        this.name = name;
        this.time = time;
        this.peopleList = Arrays.asList(creator);
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

    public LiveData<List<Person>> getFilmList() {
        return peopleList;
    }

    public void setFilmList(List<Person> filmList) {
        this.peopleList = filmList;
    }
}
