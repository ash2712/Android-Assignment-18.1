package com.example.ayush.batterypercentageapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.os.BatteryManager.EXTRA_LEVEL;

public class MainActivity extends AppCompatActivity {

    int batteryLevel;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(BatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        //registering reciever
        tv = (TextView) findViewById(R.id.textView);

    }

    private BroadcastReceiver BatteryReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
            batteryLevel = intent.getIntExtra(EXTRA_LEVEL, 0);
            //gets the battery level
            String sentence = "Battery Percentage remaining = " + batteryLevel;
            tv.setText(sentence);
            //sets the text to math the battery leve;
        }

    };


}
