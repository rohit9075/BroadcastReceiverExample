package com.rohit.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

// Broadcast receiver class
public class PhoneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // bundle object
        Bundle extras = intent.getExtras();
        if (extras != null) {

            // getting the phone call state
            String state = extras.getString(TelephonyManager.EXTRA_STATE);

            Log.d("PhoneReceiver", state);

            // checking phone state for ringing
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

                // if phone is ringing, Phone number is saving to variable
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("PhoneReceiver", phoneNumber);
            }

        }
    }
}
