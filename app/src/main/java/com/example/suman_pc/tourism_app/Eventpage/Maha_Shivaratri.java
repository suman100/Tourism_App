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

public class Maha_Shivaratri extends AppCompatActivity {
    private TextView mValueview,mValueview1, mValueview2, mValueview3,mValueview4,mValueview5,mValueview6 ;
    private com.firebase.client.Firebase mref;
    private com.firebase.client.Firebase mref1;
    private com.firebase.client.Firebase mref2;
    private com.firebase.client.Firebase mref3;
    private com.firebase.client.Firebase mref4;
    private com.firebase.client.Firebase mref5;
    private com.firebase.client.Firebase mref6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maha__shivaratri);

        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ImageView imageView1 = (ImageView) findViewById(R.id.image_shiva1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.image_shiva2);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ktm);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ShivaRatri ");

        String url = "http://1hu9t72zwflj44abyp2h0pfe-wpengine.netdna-ssl.com/wp-content/uploads/2016/03/Sadhu-smokes-marijuana-in-Pashupatinath-Temple-for-Mahashivaratri.jpg";
        String url1 = "https://secure.i.telegraph.co.uk/multimedia/archive/01577/hindu13_CROWD_1577252i.jpg";
        String url2 = "http://www.ananyanepal.com/images/packages/gallery/shivaratri%20in%20nepal.jpg";

        Picasso.with(this).load(url).into(imageView);
        Picasso.with(this).load(url1).into(imageView1);
        Picasso.with(this).load(url2).into(imageView2);


//     For Database

        mValueview = (TextView) findViewById(R.id.Valueview);
        mValueview1 = (TextView) findViewById(R.id.Valueview1);
        mValueview2 = (TextView) findViewById(R.id.Valueview2);
        mValueview3 = (TextView) findViewById(R.id.Valueview3);
        mValueview4 = (TextView) findViewById(R.id.Valueview4);
        mValueview5 = (TextView) findViewById(R.id.Valueview5);
        mValueview6 = (TextView) findViewById(R.id.Valueview6);


        mref = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shivaratri");
        mref1 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shiva1");
        mref2 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shiva2");
        mref3 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shiva3");
        mref4 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shiva4");
        mref5 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shiva5");
        mref6 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/shiva6");

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

        mref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview5.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mref6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mValueview6.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}

