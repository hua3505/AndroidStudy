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
        showCustomNotification();
        showNotification();
    }

    private void showCustomNotification() {
        Notification foregroundNote;

        RemoteViews bigView = new RemoteViews(getApplicationContext().getPackageName(),
                R.layout.notification_layout_big);

// bigView.setOnClickPendingIntent() etc..

//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        foregroundNote = builder.setCustomContentView(bigView).setSmallIcon(R.mipmap.ic_launcher).build();

        Notification.Builder notifyBuilder = new Notification.Builder(this);
        foregroundNote = notifyBuilder.setContent(bigView)
                .setSmallIcon(R.drawable.icon)
                .build();

//        foregroundNote.bigContentView = bigView;

// now show notification..
        NotificationManager mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyManager.notify(1, foregroundNote);
    }

    private void showNotification() {
        Notification notification;
        Notification.Builder builder = new Notification.Builder(this);
        notification = builder.setSmallIcon(R.drawable.icon)
                .setContentTitle("发现新的自启应用")
                .setContentText("招商银行 会在后台静默启动")
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }
}
