package com.example.filmapp.Presentation.Repository.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.filmapp.Presentation.Repository.Model.FilmDTO;
import com.example.filmapp.Presentation.Repository.Room.DAO.FilmDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FilmDTO.class}, version = 1, exportSchema = false)
public abstract class FilmRoomDatabase extends RoomDatabase {
    public abstract FilmDAO filmDao();

    private static volatile FilmRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FilmRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FilmRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FilmRoomDatabase.class, "word_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}