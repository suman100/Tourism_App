package com.example.suman_pc.tourism_app.Trekkingpage;

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
public class Trekking extends android.support.v4.app.Fragment {
    private ListView nlistview;
    private Toolbar supportActionBar;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listview_trek, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.Headerimage_trek);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_trek);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Trekking ");
        Glide.with(this).load(R.drawable.headertrek).fitCenter().into(imageView);
        nlistview = (ListView) view.findViewById(R.id.listView_trek);
        final ArrayList<cards_trek> list1 = new ArrayList<>();
        list1.add(new cards_trek("drawable://" + R.drawable.everest, "Everest Basecamp"));
        list1.add(new cards_trek("drawable://" + R.drawable.annapurna, "Annapurna Basecamp"));
        list1.add(new cards_trek("drawable://" + R.drawable.poonhill, "PoonHill"));
        list1.add(new cards_trek("drawable://" + R.drawable.langtang, "Langtang Trek"));
        list1.add(new cards_trek("drawable://" + R.drawable.mustang, "Upper-Mustang"));


        CustomListAdapter_trek adapter_home = new CustomListAdapter_trek(getActivity(), R.layout.fragment_trekking, list1);
        nlistview.setAdapter(adapter_home);
        nlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent myintent = new Intent(view.getContext(), Everest_basecamp.class);
                    startActivityForResult(myintent, 0);
                }

                if (position == 1) {
                    Intent myintent = new Intent(view.getContext(), Annapurna_basecamp.class);
                    startActivityForResult(myintent, 1);
                }

                if (position == 2) {
                    Intent myintent = new Intent(view.getContext(), Poonhill.class);
                    startActivityForResult(myintent, 2);
                }

                if (position == 3) {
                    Intent myintent = new Intent(view.getContext(), Langtang.class);
                    startActivityForResult(myintent, 3);
                }

                if (position == 4) {
                    Intent myintent = new Intent(view.getContext(),Upper_mustang.class);
                    startActivityForResult(myintent, 4);
                }


            }
        });



        return view;
    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}
