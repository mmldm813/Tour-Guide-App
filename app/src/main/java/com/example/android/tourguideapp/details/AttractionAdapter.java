package com.example.android.tourguideapp.details;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.models.Attraction;

import java.util.ArrayList;

/**
 * Created by michellemedina on 12/14/17.
 */

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView attractionName;
        ImageView attractionPic;

        AttractionViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            attractionName = itemView.findViewById(R.id.attraction_name);
            attractionPic = itemView.findViewById(R.id.attraction_pic);
        }
    }

    private ArrayList<Attraction> attractions;

    public AttractionAdapter(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.attraction_card_view, viewGroup, false);
        AttractionViewHolder viewHolder = new AttractionViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, final int position) {
        final String attractionName = attractions.get(position).attractionName;
        final String attractionDescription = attractions.get(position).attractionDescription;
        final String attractionAddress = attractions.get(position).attractionAddress;
        final String attractionHours = attractions.get(position).attractionHours;

        holder.attractionName.setText(attractionName);
        holder.attractionPic.setImageResource(attractions.get(position).imageResourceID);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttractionActivity.startWith(view.getContext(), attractionName,
                        attractionDescription, attractionAddress, attractionHours );

            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}


