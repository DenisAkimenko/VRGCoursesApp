package com.example.denis.vrgcoursesapp.ui.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.ui.mostemailed.MostEmailedFragment;
import com.example.denis.vrgcoursesapp.ui.favourites.FavoritesFragment;
import com.example.denis.vrgcoursesapp.ui.mostshared.MostSharedFragment;
import com.example.denis.vrgcoursesapp.ui.mostviewed.MostViewedFragment;

public class TabsViewPagerAdapter extends FragmentPagerAdapter {

    private static final int COUNT_ITEMS = 4;

    private static final int MOST_EMAILED_TAB_POSITION = 0;

    private static final int MOST_SHARED_TAB_POSITION = 1;

    private static final int MOST_VIEWED_TAB_POSITION = 2;

    private static final int FAVOURITE_TAB_POSITION = 3;

    private MostEmailedFragment mMostEmailedFragment;

    private MostSharedFragment mMostSharedFragment;

    private MostViewedFragment mMostViewedFragment;

    private FavoritesFragment mFavoritesFragment;

    private Context mContext;

    public TabsViewPagerAdapter(FragmentManager fragmentManager,
                                MostEmailedFragment mostEmailedFragment,
                                MostSharedFragment mostSharedFragment,
                                MostViewedFragment mostViewedFragment,
                                FavoritesFragment favoritesFragment,
                                Context context) {
        super(fragmentManager);
        mMostEmailedFragment = mostEmailedFragment;
        mMostSharedFragment = mostSharedFragment;
        mMostViewedFragment = mostViewedFragment;
        mFavoritesFragment = favoritesFragment;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MOST_EMAILED_TAB_POSITION:
                return mMostEmailedFragment;
            case MOST_SHARED_TAB_POSITION:
                return mMostSharedFragment;
            case MOST_VIEWED_TAB_POSITION:
                return mMostViewedFragment;
            case FAVOURITE_TAB_POSITION:
                return mFavoritesFragment;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case MOST_EMAILED_TAB_POSITION:
                return mContext.getString(R.string.frag_most_emailed_title);
            case MOST_SHARED_TAB_POSITION:
                return mContext.getString(R.string.frag_most_shared_title);
            case MOST_VIEWED_TAB_POSITION:
                return mContext.getString(R.string.frag_most_viewed_title);
            case FAVOURITE_TAB_POSITION:
                return mContext.getString(R.string.frag_favorites_title);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return COUNT_ITEMS;
    }
}