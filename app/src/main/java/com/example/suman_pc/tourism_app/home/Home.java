package com.example.suman_pc.tourism_app.home;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.suman_pc.tourism_app.Activity.CustomListAdapter;
import com.example.suman_pc.tourism_app.Navigation;
import com.example.suman_pc.tourism_app.R;

import java.util.ArrayList;

/**
 * Created by suman-PC on 4/3/2018.
 */
public class Home extends android.support.v4.app.Fragment{
    private ListView nlistview;
    private Toolbar supportActionBar;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.listview_home, container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.Headerimage);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Home ");
        Glide.with(this).load(R.drawable.homeimage).fitCenter().into(imageView);
        nlistview = (ListView) view.findViewById(R.id.listView_home);
        final ArrayList<cards_home> list1 = new ArrayList<>();

        list1.add(new cards_home("drawable://" + R.drawable.ktm, "Kathmandu"));
        list1.add(new cards_home("drawable://" + R.drawable.pokhara, "Pokhara"));
        list1.add(new cards_home("drawable://" + R.drawable.chitwan, "Chitwan"));
        list1.add(new cards_home("drawable://" + R.drawable.bhaktapur1, "Bhaktapur"));
        list1.add(new cards_home("drawable://" + R.drawable.patan1, "Patan"));

        CustomListAdapter_home adapter_home = new CustomListAdapter_home(getActivity(), R.layout.fragment_home, list1);
        nlistview.setAdapter(adapter_home);
        nlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent myintent = new Intent(view.getContext(), Kathmandu.class);
                    startActivityForResult(myintent, 0);
                }

                if (position == 1) {
                    Intent myintent = new Intent(view.getContext(), Pokhara.class);
                    startActivityForResult(myintent, 1);
                }

                if (position == 2) {
                    Intent myintent = new Intent(view.getContext(), Chitwan.class);
                    startActivityForResult(myintent, 2);
                }

                if (position == 3) {
                    Intent myintent = new Intent(view.getContext(), Bhaktapur.class);
                    startActivityForResult(myintent, 3);
                }

                if (position == 4) {
                    Intent myintent = new Intent(view.getContext(), Patan.class);
                    startActivityForResult(myintent, 4);
                }

            }
        });


        return view;
    }


    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    public Toolbar getSupportActionBar() {
        return supportActionBar;
    }
}
