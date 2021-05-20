package com.example.countriesjava.util;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

public class myFireBaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(@NonNull @NotNull RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);

    }
}
