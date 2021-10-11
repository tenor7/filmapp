package com.example.filmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.filmapp.Presentation.Repository.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository.init(getApplication());
    }
}