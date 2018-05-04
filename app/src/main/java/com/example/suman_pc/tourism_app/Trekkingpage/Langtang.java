package com.example.suman_pc.tourism_app.Trekkingpage;

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




public class Langtang extends AppCompatActivity {
    private TextView mValueview,mValueview1, mValueview2 ;
    private com.firebase.client.Firebase mref;
    private com.firebase.client.Firebase mref1;
    private com.firebase.client.Firebase mref2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langtang);

        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        final ImageView imageView1 = (ImageView) findViewById(R.id.image_langtang1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.image_langtang2);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ktm);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" Langtang  ");

        String url = "https://www.langtang.com/public/uploads/frontend/main/langtang_ri_1467177179.019.jpg";
        String url1 = "http://farabovetheclouds.com/wp-content/uploads/2017/08/Langtang-Valley.jpg";
        String url2 = "http://www.nepaltrekkingtouroperators.com/assets/Template/images/packages/trekking-in-nepal/Langtang-region-trekking/Langtang-Valley-Trek/Langtang-Valley-trek.jpg";

        Picasso.with(this).load(url).into(imageView);
        Picasso.with(this).load(url1).into(imageView1);
        Picasso.with(this).load(url2).into(imageView2);



//     For Database

        mValueview = (TextView) findViewById(R.id.Valueview);
        mValueview1 = (TextView) findViewById(R.id.Valueview1);
        mValueview2 = (TextView) findViewById(R.id.Valueview2);



        mref = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/langtang");
        mref1 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/langtang1");
        mref2 = new com.firebase.client.Firebase("https://tourismapp-782d1.firebaseio.com/langtang2");


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


    }

}

