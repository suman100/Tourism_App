package com.example.suman_pc.tourism_app.home;

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
import android.widget.ViewFlipper;

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

public class Chitwan extends AppCompatActivity implements OnMapReadyCallback {
    private TextView mValueview,mValueview1, mValueview2, mValueview3,mValueview4,mValueview5 ;
    private com.firebase.client.Firebase mref;
    private com.firebase.client.Firebase mref1;
    private com.firebase.client.Firebase mref2;
    private com.firebase.client.Firebase mref3;
    private com.firebase.client.Firebase mref4;
    private com.firebase.client.Firebase mref5;
    private Button buttonmapktm;
    GoogleMap mgooglemap;
    ViewFlipper view_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitwan);
        buttonmapktm = (Button) findViewById(R.id.buttonmapktm);


        if (googleServiceAvailable()){
            Toast.makeText(this, "Perfect", Toast.LENGTH_LONG).show();
            initMap();
        }else {
            //No Google map
        }

        view_flipper = findViewById(R.id.view_flipper);
        int images[] = {R.drawable.cht0, R.drawable.cht1,R.drawable.cht2};

        for (int image: images){
            flipperimage(image);
        }

        //final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ImageView imageView1 = (ImageView) findViewById(R.id.image_chitwan1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.image_chitwan2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.image_chitwan3);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ktm);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Chitwan ");

        //String url = "https://www.welcomenepal.com/uploads/destination/One-horned-rhinoceros-in-Chitwan-National-Park-Nepal.jpg";
        String url1 = "https://secure.i.telegraph.co.uk/multimedia/archive/01525/walking-puma_1525325i.jpg";
        String url2 = "http://www.chitwantourism.com/chitwan-news/pictures/chitwan-jungle-jeep-safari-tour.jpg";
        String url3 = "http://imnepal.com/wp-content/uploads/2016/11/chitwan-national-park-famous-destination-in-Nepal-for-tourist.jpg";


        //Picasso.with(this).load(url).into(imageView);
        Picasso.with(this).load(url1).into(imageView1);
        Picasso.with(this).load(url2).into(imageView2);
        Picasso.with(this).load(url3).into(imageView3);



//     For Database

        mValueview = (TextView) findViewById(R.id.Valueview);
        mValueview1 = (TextView) findViewById(R.id.Valueview1);
        mValueview2 = (TextView) findViewById(R.id.Valueview2);
        mValueview3 = (TextView) findViewById(R.id.Valueview3);
        mValueview4 = (TextView) findViewById(R.id.Valueview4);
        mValueview5 = (TextView) findViewById(R.id.Valueview5);


        mref = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/chitwan");
        mref1 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/chitwan2");
        mref2 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/chitwan3");
        mref3 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/chitwan4");
        mref4 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/chitwan5");
        mref5 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/chitwan6");

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

        buttonmapktm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Chitwan.this, Map.class));
            }
        });
    }

    public void  flipperimage(int image){
        ImageView imageview = new ImageView(this);
        imageview.setBackgroundResource(image);
        view_flipper.addView(imageview);
        view_flipper.setFlipInterval(3000);
        view_flipper.setAutoStart(true);
        view_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        view_flipper.setInAnimation(this, android.R.anim.slide_out_right);

    }

    private void initMap() {
        MapFragment mapfragment= (MapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);
        mapfragment.getMapAsync(this);
    }

    public boolean googleServiceAvailable(){
        GoogleApiAvailability api= GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS){
            return true;
        }else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog =api.getErrorDialog(this,isAvailable,0);
            dialog.show();
        }else {
            Toast.makeText(this, "cant connect to play service", Toast.LENGTH_LONG).show();

        }
        return false;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgooglemap = googleMap;
        goToLocationZoom(27.7172, 85.3240,15);
    }

    private void goToLocation(double lat, double lng) {
        LatLng ll=new LatLng(lat,lng);
        CameraUpdate update= CameraUpdateFactory.newLatLng(ll);
        mgooglemap.moveCamera(update);
    }

    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll=new LatLng(lat,lng);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mgooglemap.moveCamera(update);
    }


}

