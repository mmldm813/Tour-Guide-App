package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class AttractionActivity extends AppCompatActivity {
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_DESCRIPTION = "description";
    private static final String EXTRA_DIRECTIONS = "address";
    private static final String EXTRA_HOURS = "hours";

    private String description;
    private String directions;
    private String hours;

    public static void startWith(Context context, String title, String description,
                                 String address, String hours) {
        Intent intent = new Intent(context, AttractionActivity.class);
        intent.putExtra(EXTRA_TITLE, title);
        intent.putExtra(EXTRA_DESCRIPTION, description);
        intent.putExtra(EXTRA_DIRECTIONS, address);
        intent.putExtra(EXTRA_HOURS, hours);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_tabs);

        setupTitle();
        setupVariablesFromIntent();
        setupTabs();
    }

    private void setupTitle() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        setTitle(title);
    }

    private void setupVariablesFromIntent() {
        Intent intent = getIntent();
        description = intent.getStringExtra(EXTRA_DESCRIPTION);
        directions = intent.getStringExtra(EXTRA_DIRECTIONS);
        hours = intent.getStringExtra(EXTRA_HOURS);
    }

    private void setupTabs() {
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class TabsAdapter extends FragmentPagerAdapter {
        private int tabTitles[] = new int[] { R.string.information, R.string.hours_directions };

        public TabsAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return InformationFragment.newInstance(description);
            } else if (position == 1){
                return AddressFragment.newInstance(directions, hours);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(tabTitles[position]);
        }
    }
}
