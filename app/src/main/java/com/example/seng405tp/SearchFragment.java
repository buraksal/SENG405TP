package com.example.seng405tp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seng405tp.Retrofit.RetrofitClient;
import com.example.seng405tp.models.SearchMovie;
import com.google.gson.Gson;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnSearchMovie = view.findViewById(R.id.btnSearchMovie);
        EditText movieSearchText = view.findViewById(R.id.searchMovie);
        recyclerView = view.findViewById(R.id.searchMoviesRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        btnSearchMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMovies(movieSearchText.getText().toString());
            }
        });
    }

    public void getMovies(String movieText){
        Call<SearchMovie> call = RetrofitClient.getInstance().getMyApi().getMovies(movieText);
        call.enqueue(new Callback<SearchMovie>() {
            @Override
            public void onResponse(Call<SearchMovie> call, Response<SearchMovie> response) {
                Log.d("MyActivity", (new Gson()).toJson(response.body()));
                SearchMovie movieList = response.body();
                CustomAdapter customAdapter = new CustomAdapter(getContext(), movieList.getResults(), true);
                recyclerView.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<SearchMovie> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occurred.", Toast.LENGTH_LONG).show();
            }
        });
    }

}