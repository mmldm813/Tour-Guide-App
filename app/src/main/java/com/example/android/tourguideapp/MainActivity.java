package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private City city;
    private ArrayList<Attraction> attractions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createModels();
        setupCityInfo();
        setupAttractionCardList();
    }

    private void createModels() {
        attractions.add(new Attraction("Vizcaya Museum and Gardens",
                R.drawable.villa_vizcaya, getString(R.string.vizcaya_description),
                getString(R.string.vizcaya_address), getString(R.string.vizcaya_hours)));
        attractions.add(new Attraction("Lincoln Road", R.drawable.lincoln_road,
                getString(R.string.lincoln_road_description),
                getString(R.string.lincoln_road_address), getString(R.string.lincoln_road_hours)));
        attractions.add(new Attraction("Coral Castle", R.drawable.coralcastlenight,
                getString(R.string.coral_castle_description),
                getString(R.string.coral_castle_address), getString(R.string.coral_castle_hours)));
        attractions.add(new Attraction("Venetian Pool", R.drawable.venetian_pool,
                getString(R.string.venetian_pool_description),
                getString(R.string.venetian_pool_address), getString(R.string.venetian_pool_hours)));

        city = new City("Miami",getString(R.string.miami_city_description));
    }

    private void setupCityInfo() {
        setTitle(city.getCityName());
        TextView cityDescription = findViewById(R.id.city_description);
        cityDescription.setText(city.getCityDescription());
    }

    private void setupAttractionCardList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager list = new LinearLayoutManager(this);
        list.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(list);

        AttractionAdapter adapter = new AttractionAdapter(attractions);
        recyclerView.setAdapter(adapter);
    }
}
