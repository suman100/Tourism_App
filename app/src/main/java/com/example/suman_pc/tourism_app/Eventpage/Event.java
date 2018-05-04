package com.example.suman_pc.tourism_app.Eventpage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.suman_pc.tourism_app.Navigation;
import com.example.suman_pc.tourism_app.R;

import java.util.ArrayList;

/**
 * Created by suman-PC on 4/3/2018.
 */
public class Event extends android.support.v4.app.Fragment {
    private ListView nlistview;

    private Toolbar supportActionBar;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listview_events, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.Headerimage_events);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_events);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Events ");
        Glide.with(this).load(R.drawable.eventsheader).fitCenter().into(imageView);
        nlistview = (ListView) view.findViewById(R.id.listView_events);
        final ArrayList<cards_events> list1 = new ArrayList<>();

        list1.add(new cards_events("drawable://" + R.drawable.dashain, "Dashain"));
        list1.add(new cards_events("drawable://" + R.drawable.tihar, "Tihar"));
        list1.add(new cards_events("drawable://" + R.drawable.holi, "Holi"));
        list1.add(new cards_events("drawable://" + R.drawable.shivaratri, "Maha-ShivaRatri"));
        list1.add(new cards_events("drawable://" + R.drawable.teej, "Haritalika_Teej"));
        list1.add(new cards_events("drawable://" + R.drawable.bisketjatra, "Bisket_Jatra"));

        CustomListAdapter_events adapter_home = new CustomListAdapter_events(getActivity(), R.layout.fragment_events, list1);
        nlistview.setAdapter(adapter_home);
        nlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent myintent = new Intent(view.getContext(), Dashain.class);
                    startActivityForResult(myintent, 0);
                }

                if (position == 1) {
                    Intent myintent = new Intent(view.getContext(), Tihar.class);
                    startActivityForResult(myintent, 1);
                }

                if (position == 2) {
                    Intent myintent = new Intent(view.getContext(), Holi.class);
                    startActivityForResult(myintent, 2);
                }

                if (position == 3) {
                    Intent myintent = new Intent(view.getContext(), Maha_Shivaratri.class);
                    startActivityForResult(myintent, 3);
                }

                if (position == 4) {
                    Intent myintent = new Intent(view.getContext(), Haritalika_Teej.class);
                    startActivityForResult(myintent, 4);
                }

                if (position == 5) {
                    Intent myintent = new Intent(view.getContext(), Bisket_Jatra.class);
                    startActivityForResult(myintent, 5);
                }
            }
        });

        return view;

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}
