package com.example.seng405tp.models;

import java.util.List;
public class SearchMovie {
    String searchType;
    String expression;
    List<MovieResult> results;
    String errorMessage;

    public List<MovieResult> getResults(){
        return results;
    }
}
