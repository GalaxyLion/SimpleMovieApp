package com.example.galax.simplemovieapp.screens.movie;

import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

public class MovieView implements MovieContract.View {

    private View root;
    private MoviePageAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BaseActivity activity;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private View btnProfile;
    private View btnLogout;

    public MovieView(View root, DrawerLayout drawer, BaseActivity baseActivity) {
        this.root = root;
        this.activity = baseActivity;
        this.drawer = drawer;
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) root.findViewById(R.id.pager);
        tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);
        adapter = new MoviePageAdapter(activity.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        toolbar = root.findViewById(R.id.toolbar);
        btnProfile = drawer.findViewById(R.id.profile_btn);
        btnLogout = drawer.findViewById(R.id.logout_btn);


        initBtnActionMenuToolbar();

    }

    private void initBtnActionMenuToolbar() {

        toolbar.setNavigationOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });
    }

    @Override
    public Observable<Object> profileBtnAction() {
        return RxView.clicks(btnProfile);
    }

    @Override
    public Observable<Object> logoutBtnAction() {
        return RxView.clicks(btnLogout);
    }

    @Override
    public void showToast() {
        Toast.makeText(activity.getApplicationContext(),"Toast", Toast.LENGTH_SHORT).show();
    }
}
