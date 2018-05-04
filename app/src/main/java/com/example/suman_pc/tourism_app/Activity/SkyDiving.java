package com.example.suman_pc.tourism_app.Activity;

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

public class SkyDiving extends AppCompatActivity{
    private TextView mValueview,mValueview1, mValueview2, mValueview3,mValueview4 ;
    private com.firebase.client.Firebase mref;
    private com.firebase.client.Firebase mref1;
    private com.firebase.client.Firebase mref2;
    private com.firebase.client.Firebase mref3;
    private com.firebase.client.Firebase mref4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky_diving);

        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ImageView imageView1 = (ImageView) findViewById(R.id.image_skydive1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.image_skydive2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.image_skydive3);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ktm);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Sky Diving ");

        String url = "https://www.everest-skydive.com/wp-content/uploads/2012/06/pagestop4-1024x243.jpg";
        String url1 = "https://www.outlookindia.com/outlooktraveller/wp-content/uploads/2017/10/Skydiving.jpg";
        String url2 = "https://www.aviationnepal.com/wp-content/uploads/2017/11/pokhara-skydive-9.jpg";
        String url3 = "https://1.bp.blogspot.com/-MSVPKlwryp8/V4_AK2FbAXI/AAAAAAAAOa4/d08UF3KXCgQq3NHxiBvVQQmLfM147VuQwCLcB/s640/pokhara-skydive-18.jpg";


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


        mref = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/skydive");
        mref1 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/skydive1");
        mref2 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/skydive2");
        mref3 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/skydive3");
        mref4 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/skydive4");

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

