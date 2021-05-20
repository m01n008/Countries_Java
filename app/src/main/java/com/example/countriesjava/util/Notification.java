package com.example.countriesjava.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Notification {

    public void SendNotification(String Token, String Title, String Body, Context context) {

        String url = "https://fcm.googleapis.com/fcm/send";
        String API_KEY = "AAAAkeZp-9Q:APA91bHOV7prxg8k8MWw4cVCHcyRzYp9iSXK3OPKTwPmVCeMWqunSwVEAyzlkZw1nThOZCl-athImM3raywOBZFM6qrv5sY9xFOKuZOVLUclArP6sBv66t9GYNQ8xhY7HThIPGmrMuaC";
        JSONObject json = new JSONObject();
        JSONObject notificationData = new JSONObject();
        JSONObject userData = new JSONObject();
        try {

            RequestQueue requestQueue;

            requestQueue = Volley.newRequestQueue(context);

            requestQueue.start();

            notificationData.put("title", Title);
            notificationData.put("body", Body);

            userData.put("title", Title);
            userData.put("body", Body);

            json.put("notification", notificationData);
            json.put("data", userData);
            json.put("to", Token);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, json, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap hashMap = new HashMap();

                    hashMap.put("Authorization", "key=" + API_KEY);
                    hashMap.put("Content-TYpe", "application-json");

                    return hashMap;

                }
            };

            requestQueue.add(jsonObjectRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
