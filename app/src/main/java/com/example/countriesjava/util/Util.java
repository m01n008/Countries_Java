package com.example.countriesjava.util;

import android.content.Context;
import android.os.Build;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.countriesjava.R;

import org.jetbrains.annotations.NotNull;


public class Util {


    @RequiresApi(api = Build.VERSION_CODES.Q)
    public final static CircularProgressDrawable getProgressBarDrawable(Context context) {

        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setCenterRadius(50f);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

    public final static void loadImage(@NotNull ImageView imageView, @Nullable String url,
                                 @Nullable CircularProgressDrawable circularProgressDrawable) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(circularProgressDrawable)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(imageView.getContext())
                .applyDefaultRequestOptions(requestOptions)
                .load(url)
                .into(imageView);


    }

}
