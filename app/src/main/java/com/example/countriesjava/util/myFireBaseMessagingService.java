package com.example.countriesjava.util;

import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.countriesjava.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class myFireBaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(@NonNull @NotNull RemoteMessage remoteMessage) {
        createNotification(remoteMessage);
        super.onMessageReceived(remoteMessage);


    }

    public void createNotification(RemoteMessage remoteMessage) {

        String channelID = "com.example.countriesjava";
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this, channelID);
        mbuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setPriority(NotificationCompat.PRIORITY_MAX);

        NotificationManager notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, mbuilder.build());


    }


}
