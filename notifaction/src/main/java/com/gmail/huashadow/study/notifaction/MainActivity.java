package com.gmail.huashadow.study.notifaction;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNotification();
    }

    private void showNotification() {
        Notification foregroundNote;

        RemoteViews bigView = new RemoteViews(getApplicationContext().getPackageName(),
                R.layout.notification_layout_big);

// bigView.setOnClickPendingIntent() etc..

//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        foregroundNote = builder.setCustomContentView(bigView).setSmallIcon(R.mipmap.ic_launcher).build();

        Notification.Builder mNotifyBuilder = new Notification.Builder(this);
        foregroundNote = mNotifyBuilder.setContent(bigView)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

//        foregroundNote.bigContentView = bigView;

// now show notification..
        NotificationManager mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyManager.notify(1, foregroundNote);
    }
}
