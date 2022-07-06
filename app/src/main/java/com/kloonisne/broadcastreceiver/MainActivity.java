package com.kloonisne.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/*
     This app will show an alert dialog when user turn on airplane mode (done using
     broadcast receiver and intent filter
*/
public class MainActivity extends AppCompatActivity {
    //initializing object of HelperBroadCastReceiver class
    HelperBroadCastReceiver receiver = new HelperBroadCastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating intent filter to receive airplane mode changes
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //registering broadcast receiver and filter
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregistering
        unregisterReceiver(receiver);
    }
}