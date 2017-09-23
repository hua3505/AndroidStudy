package com.gmail.huashadow.study.anr;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String ACTION = "BLOCK_BROADCAST";

    private MyBroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
        sendBroadcast();
    }

    private void registerReceiver() {
        mReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(ACTION);
        registerReceiver(mReceiver, intentFilter);
    }

    private void sendBroadcast() {
        Intent intent = new Intent(ACTION);
        sendBroadcast(intent);
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive");
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                Log.d(TAG, "", e);
            }
            Log.d(TAG, "onReceive end");
        }
    }
}
