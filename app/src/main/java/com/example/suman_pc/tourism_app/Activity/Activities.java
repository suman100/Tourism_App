package com.example.suman_pc.tourism_app.Activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.suman_pc.tourism_app.Navigation;
import com.example.suman_pc.tourism_app.R;

import java.util.ArrayList;


/**
 * Created by suman-PC on 4/3/2018.
 */
public class Activities extends android.support.v4.app.Fragment implements View.OnClickListener {
    private static final String TAG = "Activities";

    private ListView mListView;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listview_layout, container, false);
        final ImageView imageView = view.findViewById(R.id.Headerimage);
        final Toolbar toolbar = view.findViewById(R.id.toolbar_activity);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = view.findViewById(R.id.collapsing_toolbar_activity);
        collapsingToolbar.setTitle(" Activity ");
        Glide.with(this).load(R.drawable.activityheader).fitCenter().into(imageView);


        mListView = (ListView) view.findViewById(R.id.listView);

        final ArrayList<cards> list = new ArrayList<>();

        list.add(new cards("drawable://" + R.drawable.bungy, "Bungee Jump"));
        list.add(new cards("drawable://" + R.drawable.paragliding, "Paragliding"));
        list.add(new cards("drawable://" + R.drawable.skydiving, "Sky Diving"));
        list.add(new cards("drawable://" + R.drawable.zipflying, "Zip Flying"));
        list.add(new cards("drawable://" + R.drawable.rafting, "Rafting"));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.fragment_activities, list);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (pos == 0) {
                    Intent myintent = new Intent(view.getContext(), Bungy.class);
                    startActivityForResult(myintent, 0);
                }

                if (pos == 1) {
                    Intent myintent = new Intent(view.getContext(), Paragliding.class);
                    startActivityForResult(myintent, 1);
                }

                if (pos == 2) {
                    Intent myintent = new Intent(view.getContext(), SkyDiving.class);
                    startActivityForResult(myintent, 2);
                }

                if (pos == 3) {
                    Intent myintent = new Intent(view.getContext(), ZipFlying.class);
                    startActivityForResult(myintent, 3);
                }

                if (pos == 4) {
                    Intent myintent = new Intent(view.getContext(), Rafting.class);
                    startActivityForResult(myintent, 4);
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
    }
}
