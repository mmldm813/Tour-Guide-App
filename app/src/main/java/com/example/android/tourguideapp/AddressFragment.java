package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddressFragment extends Fragment {

    private static final String BUNDLE_DIRECTIONS = "address";
    private static final String BUNDLE_HOURS = "hours";

    public static AddressFragment newInstance(String address, String hours) {
        AddressFragment f = new AddressFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_DIRECTIONS, address);
        args.putString(BUNDLE_HOURS, hours);
        f.setArguments(args);
        return f;
    }

    public AddressFragment() {
        // Required empty public constructor
    }

    private String getDirections(){
        return getArguments().getString(BUNDLE_DIRECTIONS);
    }

    private String getHours(){
        return getArguments().getString(BUNDLE_HOURS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hours_address_content_inside_tabs, container, false);
        ((TextView)view.findViewById(R.id.directions)).setText(getDirections());
        ((TextView)view.findViewById(R.id.hours)).setText(getHours());
        return view;
    }
}
