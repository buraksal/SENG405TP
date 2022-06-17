package com.example.seng405tp.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.seng405tp.models.MovieResult;
import com.example.seng405tp.models.MovieResultDAO;

@Database(entities = {MovieResult.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieResultDAO movieResultDAO();
}
