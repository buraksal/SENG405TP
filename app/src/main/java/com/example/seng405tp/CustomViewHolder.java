package com.example.seng405tp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView titleText, descriptionText;
    public ImageView movieImage;
    public Button addToFavBtn, removeFromFavBtn;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.titleText);
        descriptionText = itemView.findViewById(R.id.descriptionText);
        movieImage = itemView.findViewById(R.id.movieImage);
        addToFavBtn = itemView.findViewById(R.id.addToFavs);
        removeFromFavBtn = itemView.findViewById(R.id.removeFromFav);

    }
}
