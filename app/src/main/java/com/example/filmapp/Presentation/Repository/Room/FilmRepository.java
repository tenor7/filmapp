package com.example.filmapp.Presentation.Repository.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.filmapp.Domain.Model.Film;
import com.example.filmapp.Presentation.Repository.Model.FilmDTO;
import com.example.filmapp.Presentation.Repository.RepositoryTasks;
import com.example.filmapp.Presentation.Repository.Room.DAO.FilmDAO;

import java.util.List;

public class FilmRepository implements RepositoryTasks {
    private FilmDAO mFilmDao;
    private LiveData<List<FilmDTO>> mAllFilms = new MutableLiveData<>();

    public FilmRepository(Application application) {
        FilmRoomDatabase db = FilmRoomDatabase.getDatabase(application);
        mFilmDao = db.filmDao();
        mAllFilms = mFilmDao.getAllFilms();
    }

    public LiveData<List<FilmDTO>> getAllFilms() {
        return mAllFilms;
    }

    @Override
    public <T extends Film> void addFilm(T film) {
        FilmRoomDatabase.databaseWriteExecutor.execute(() -> {
            mFilmDao.addFilm(((FilmDTO) film));
        });
    }

    @Override
    public <T extends Film> void deleteFilm(T film) {
        FilmRoomDatabase.databaseWriteExecutor.execute(() -> {
            mFilmDao.deleteFilm(((FilmDTO) film));
        });
    }
}