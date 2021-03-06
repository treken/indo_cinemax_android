package com.coderYogyakarta.indo_cinemax_box_office;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.coderYogyakarta.adapter_box_office.HomeTabAdapeter;
import com.coderYogyakarta.fragment_box_office.A_zListFragment;
import com.coderYogyakarta.fragment_box_office.HomeFragment;
import com.coderYogyakarta.fragment_box_office.NewFragment;
import com.coderYogyakarta.fragment_box_office.TVSeriesFragment;
import com.coderYogyakarta.indo_cinemax_anime.HomeAnimeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.viewPagerHomeBox)
    ViewPager vpHomBox;

    @BindView(R.id.tabHomeBoxOffice)
    TabLayout tabHomeBox;

    private HomeTabAdapeter homeTabAdapeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        homeTabAdapeter = new HomeTabAdapeter(getSupportFragmentManager());
        setSupportActionBar(toolbar);
        setupViewPager(vpHomBox);
        tabHomeBox.setupWithViewPager(vpHomBox);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
    }
//    Tab scroolView
    private void setupViewPager(ViewPager viewPager){
        HomeTabAdapeter homeTabAdapeter=new HomeTabAdapeter(getSupportFragmentManager());
        homeTabAdapeter.addFragment(new HomeFragment(),"Home");
        homeTabAdapeter.addFragment(new TVSeriesFragment(),"Tv Series");
        homeTabAdapeter.addFragment(new NewFragment(),"New");
        homeTabAdapeter.addFragment(new A_zListFragment(),"A-Z List");
        viewPager.setAdapter(homeTabAdapeter);
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_anime) {
            startActivity(new Intent(HomeActivity.this, HomeAnimeActivity.class).
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        } else if (id == R.id.nav_genre) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
