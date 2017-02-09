package com.beiing.toolbar_menu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import static android.support.v4.app.NotificationCompat.PRIORITY_MAX;
import static android.support.v4.app.NotificationCompat.VISIBILITY_PRIVATE;
import static android.support.v4.app.NotificationCompat.VISIBILITY_PUBLIC;

/**
 * Created by chenliu on 2017/2/9.<br/>
 * 描述：
 * </br>
 */

public class LockService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                    try {
                        Thread.sleep(5000);
//                        Intent intent = new Intent(LockService.this,
//                                LockActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);


                        sendLockNotification();

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        }).start();

    }


    private void sendLockNotification() {
        NotificationCompat.Builder mNotifyBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle("New Message")
                        .setContentText("You've received new messages.")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setPriority(PRIORITY_MAX)
                        .setVisibility(VISIBILITY_PRIVATE);
        Notification notification = mNotifyBuilder.build();
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(100, notification);
    }


}
