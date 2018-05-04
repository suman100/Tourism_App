package com.example.suman_pc.tourism_app;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by suman-PC on 4/15/2018.
 */
public class Firebase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        com.firebase.client.Firebase.setAndroidContext(this);
        com.firebase.client.Firebase.getDefaultConfig().setPersistenceEnabled(true);

    }
}
