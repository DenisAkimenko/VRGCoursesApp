package com.example.denis.vrgcoursesapp.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tabLayout);
        setSupportActionBar(toolbar);

        MainFragment mainFragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            ActivityUtils.replaceFragmentOnActivity(getSupportFragmentManager(),
                    mainFragment, R.id.contentFrame);
        }

        new MainPresenter(mainFragment);
    }

    public void setupToolbarWithViewPager(ViewPager viewPager) {
        mTabLayout.setupWithViewPager(viewPager);
    }
}
