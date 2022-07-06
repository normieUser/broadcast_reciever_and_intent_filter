package com.kloonisne.broadcastreceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

public class HelperBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            // checking if flight mode is on, value 1 means ON and 0 means OFF
            if(Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON) == 1){
                //Code for creating alert dialog
                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("ALERT!")
                        .setMessage("Airplane mode is turned on")
                        .setPositiveButton("Ok",(dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        })
                        .show();
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

}
