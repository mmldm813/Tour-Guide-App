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
public class InformationFragment extends Fragment {
    private static final String BUNDLE_DESCRIPTION = "description";

    public static InformationFragment newInstance(String description) {
        InformationFragment f = new InformationFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_DESCRIPTION, description);
        f.setArguments(args);
        return f;
    }

    private String getDescription(){
        return getArguments().getString(BUNDLE_DESCRIPTION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_content_inside_tabs, container, false);
        ((TextView)view.findViewById(R.id.attraction_description)).setText(getDescription());
        return view;
    }
}
