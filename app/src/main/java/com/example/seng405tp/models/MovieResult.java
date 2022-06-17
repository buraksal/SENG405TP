package com.example.seng405tp.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FavouriteMovies")
public class MovieResult {
    @PrimaryKey
    @NonNull
    String id;
    String resultType;
    @ColumnInfo(name = "movie_image")
    String image;
    @ColumnInfo(name = "movie_title")
    String title;
    @ColumnInfo(name = "movie_description")
    String description;

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getImage(){
        return image;
    }
}
