package com.example.suman_pc.tourism_app;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.suman_pc.tourism_app.Activity.Activities;
import com.example.suman_pc.tourism_app.Activity.Bungy;
import com.example.suman_pc.tourism_app.Eventpage.Event;
import com.example.suman_pc.tourism_app.Morepage.More;
import com.example.suman_pc.tourism_app.Trekkingpage.Trekking;
import com.example.suman_pc.tourism_app.home.Home;

/**
 * Created by suman-PC on 4/3/2018.
 */
public class Navigation extends AppCompatActivity {
    private String actionBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);


        BottomNavigationView BottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //BottomNav.enableAnimation(false);
        BottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();       //open Home page first
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedfragment= null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedfragment= new Home();
                            break;

                        case R.id.nav_activities:
                            selectedfragment= new Activities();
                            break;

                        case R.id.nav_events:
                            selectedfragment= new Event();
                            break;

                        case R.id.nav_trekking:
                            selectedfragment= new Trekking();
                            break;

                        case R.id.nav_more:
                            selectedfragment= new More();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedfragment).commit();
                    return  true;
                }
            };


    public void setActionBarTitle(String actionBarTitle) {
        this.actionBarTitle = actionBarTitle;
    }
}