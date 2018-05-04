package com.example.suman_pc.tourism_app.Eventpage;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suman_pc.tourism_app.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;


import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suman_pc.tourism_app.Firebase;
import com.example.suman_pc.tourism_app.Morepage.Map;
import com.example.suman_pc.tourism_app.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Holi extends AppCompatActivity {
    private TextView mValueview,mValueview1, mValueview2, mValueview3,mValueview4 ;
    private com.firebase.client.Firebase mref;
    private com.firebase.client.Firebase mref1;
    private com.firebase.client.Firebase mref2;
    private com.firebase.client.Firebase mref3;
    private com.firebase.client.Firebase mref4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holi);

        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ImageView imageView1 = (ImageView) findViewById(R.id.image_holi1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.image_holi2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.image_holi3);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ktm);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Holi ");

        String url = "http://images.indianexpress.com/2018/03/holi-021.jpg";
        String url1 = "https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2018/02/26/Pictures/_f1cb8d94-1ad0-11e8-ad3f-dce09461b5da.jpg";
        String url2 = "https://cdn.cnn.com/cnnnext/dam/assets/180302095644-holi-5-exlarge-169.jpg";
        String url3 = "https://www.bergerpaints.com/imaginecolours/wp-content/uploads/2017/03/Holi-D%C3%A9cor-Ideas-for-Your-Home.png";

        Picasso.with(this).load(url).into(imageView);
        Picasso.with(this).load(url1).into(imageView1);
        Picasso.with(this).load(url2).into(imageView2);
        Picasso.with(this).load(url3).into(imageView3);



//     For Database

        mValueview = (TextView) findViewById(R.id.Valueview);
        mValueview1 = (TextView) findViewById(R.id.Valueview1);
        mValueview2 = (TextView) findViewById(R.id.Valueview2);
        mValueview3 = (TextView) findViewById(R.id.Valueview3);
        mValueview4 = (TextView) findViewById(R.id.Valueview4);


        mref = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/holi");
        mref1 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/holi1");
        mref2 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/holi2");
        mref3 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/holi3");
        mref4 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/holi4");

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview.setText(value);


            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview1.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview2.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mref3.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview3.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        }));

        mref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview4.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}

