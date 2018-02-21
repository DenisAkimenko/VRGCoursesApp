package com.example.denis.vrgcoursesapp.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.denis.vrgcoursesapp.Injection;
import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.ui.adapter.TabsViewPagerAdapter;
import com.example.denis.vrgcoursesapp.ui.favourites.FavoritesFragment;
import com.example.denis.vrgcoursesapp.ui.favourites.FavoritesPresenter;
import com.example.denis.vrgcoursesapp.ui.mostemailed.MostEmailedFragment;
import com.example.denis.vrgcoursesapp.ui.mostemailed.MostEmailedPresenter;
import com.example.denis.vrgcoursesapp.ui.mostshared.MostSharedFragment;
import com.example.denis.vrgcoursesapp.ui.mostshared.MostSharedPresenter;
import com.example.denis.vrgcoursesapp.ui.mostviewed.MostViewedFragment;
import com.example.denis.vrgcoursesapp.ui.mostviewed.MostViewedPresenter;

public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private ViewPager mTabsViewPager;

    private TabsViewPagerAdapter mTabsAdapter;

    private MostEmailedFragment mMostEmailedFragment;

    private MostSharedFragment mMostSharedFragment;

    private MostViewedFragment mMostViewedFragment;

    private FavoritesFragment mFavoritesFragment;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mTabsViewPager = root.findViewById(R.id.view_pager);
        MainActivity mainActivity = ((MainActivity) getActivity());
        mainActivity.setupToolbarWithViewPager(mTabsViewPager);

        mTabsViewPager.setAdapter(mTabsAdapter);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMostEmailedFragment = MostEmailedFragment.newInstance();
        mMostSharedFragment = MostSharedFragment.newInstance();
        mMostViewedFragment = MostViewedFragment.newInstance();
        mFavoritesFragment = FavoritesFragment.newInstance();

        new MostEmailedPresenter(Injection.provideArticlesRepository(getContext()), mMostEmailedFragment);
        new MostSharedPresenter(Injection.provideArticlesRepository(getContext()), mMostSharedFragment);
        new MostViewedPresenter(Injection.provideArticlesRepository(getContext()), mMostViewedFragment);
        new FavoritesPresenter(Injection.provideArticlesRepository(getContext()), mFavoritesFragment);

        mTabsAdapter = new TabsViewPagerAdapter(getChildFragmentManager(),
                mMostEmailedFragment,
                mMostSharedFragment,
                mMostViewedFragment,
                mFavoritesFragment, getContext());

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        //just for architecture
        //no need in this implementation
    }
}
