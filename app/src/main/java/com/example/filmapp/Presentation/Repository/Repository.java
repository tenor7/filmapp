package com.example.filmapp.Presentation.Repository;

import android.app.Application;

import com.example.filmapp.Presentation.Repository.Mock.MockBase;
import com.example.filmapp.Presentation.Repository.Mock.MockBase;
import com.example.filmapp.Presentation.Repository.Room.FilmRepository;
import com.example.filmapp.Presentation.Repository.RepositoryTasks;

public class Repository {
    static RepositoryTasks repository;

    static public void init(Application application) {
        if (repository == null) {
            repository = new FilmRepository(application);
        }
    }

    static public RepositoryTasks getRepository() {
        if (repository == null) {
            repository = new MockBase();
        }
        return repository;
    }
}
