package com.example.seng405tp.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieResultDAO {

        @Query("SELECT * FROM FavouriteMovies")
        List<MovieResult> getAll();

        @Insert
        void insert(MovieResult movie);

        @Query("SELECT * FROM FavouriteMovies WHERE id IN (:movieid)")
        MovieResult findByName(String movieid);

        @Delete
        void delete(MovieResult movie);

}
