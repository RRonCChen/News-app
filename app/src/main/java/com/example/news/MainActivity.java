package com.example.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.news.Fragments.BusinessFragment;
import com.example.news.Fragments.EntertainmentFragment;
import com.example.news.Fragments.HealthFragment;
import com.example.news.Fragments.ScienceFragment;
import com.example.news.Fragments.SportsFragment;
import com.example.news.Fragments.TechnologyFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionPageAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private class SectionPageAdapter extends FragmentPagerAdapter {

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new BusinessFragment();
                case 1:
                    return new EntertainmentFragment();
                case 2:
                    return new HealthFragment();
                case 3:
                    return new ScienceFragment();
                case 4:
                    return new SportsFragment();
                case 5:
                    return new TechnologyFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return getResources().getText(R.string.Business);
                case 1:
                    return getResources().getText(R.string.Entertainment);
                case 2:
                    return getResources().getText(R.string.Health);
                case 3:
                    return getResources().getText(R.string.Science);
                case 4:
                    return getResources().getText(R.string.Sports);
                case 5:
                    return getResources().getText(R.string.Technology);
            }
            return null;
        }
    }
}
