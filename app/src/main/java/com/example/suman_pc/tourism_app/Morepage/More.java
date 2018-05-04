package com.example.suman_pc.tourism_app.Morepage;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.suman_pc.tourism_app.MainActivity;
import com.example.suman_pc.tourism_app.Navigation;
import com.example.suman_pc.tourism_app.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

/**
 * Created by suman-PC on 4/3/2018.
 */
public class More extends android.support.v4.app.Fragment {
    private static final String TAG = "More";


    ListView listView;
    String[] values={"About US","Full Map","Feedback", "Account Info","Weather"};
    private Toolbar supportActionBar;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_more, container, false);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_more);
        setSupportActionBar(toolbar);
        toolbar.setTitle("More");


        listView = (ListView) view.findViewById(R.id.listmore);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (pos == 0) {
                    Intent myintent = new Intent(view.getContext(), AboutUs.class);
                    startActivityForResult(myintent, 0);
                }

                if (pos == 1) {
                    Intent myintent = new Intent(view.getContext(), Map.class);
                    startActivityForResult(myintent, 1);
                }

                if (pos == 2) {
                    Intent myintent = new Intent(view.getContext(), Feedback.class);
                    startActivityForResult(myintent, 2);
                }

                if (pos == 3) {
                    Intent myintent = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(myintent, 3);
                }

                if (pos == 4) {
                    Intent myintent = new Intent(view.getContext(), Weather.class);
                    startActivityForResult(myintent, 4);
                }

            }
        });
        return view;

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }


//    public boolean isServicesOK(){
//        Log.d(TAG, "isServicesOK: checking google services version");
//
//        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());
//
//        if(available == ConnectionResult.SUCCESS){
//            //everything is fine and the user can make map requests
//            Log.d(TAG, "isServicesOK: Google Play Services is working");
//            return true;
//        }
//        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
//            //an error occured but we can resolve it
//            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
//            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), available, ERROR_DIALOG_REQUEST);
//            dialog.show();
//        }else{
//            Toast.makeText(getActivity(), "You can't make map requests", Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }



}



