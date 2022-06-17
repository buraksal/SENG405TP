package com.example.seng405tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.seng405tp.models.MovieResult;
import com.example.seng405tp.models.MovieResultDAO;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{
    private Context context;
    private List<MovieResult> movieList;
    private boolean btnShow = false;

    public CustomAdapter(Context context, List<MovieResult> movieList, boolean btnShow) {
        this.context = context;
        this.movieList = movieList;
        this.btnShow = btnShow;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        MovieResult positionHolder = movieList.get(position);
        holder.titleText.setText(positionHolder.getTitle());
        holder.descriptionText.setText(positionHolder.getDescription());
        Glide.with(context)
                .load(positionHolder.getImage())
                .into(holder.movieImage);
        if(!btnShow){
            holder.addToFavBtn.setVisibility(View.GONE);
            holder.removeFromFavBtn.setVisibility(View.VISIBLE);
            holder.removeFromFavBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity myActivity = (MainActivity) context;
                    MovieResultDAO movieResultDAO = myActivity.db.movieResultDAO();
                    Thread t = new Thread(){
                        @Override
                        public void run() {
                            movieResultDAO.delete(positionHolder);
                        }
                    };
                    t.start();
                }
            });
        }
        else{
            holder.addToFavBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity myActivity = (MainActivity) context;
                    MovieResultDAO movieResultDAO = myActivity.db.movieResultDAO();
                    Thread t = new Thread(){
                        @Override
                        public void run() {
                            MovieResult mr = movieResultDAO.findByName(positionHolder.getId());
                            if(mr == null)
                                movieResultDAO.insert(positionHolder);
                        }
                    };
                    t.start();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
