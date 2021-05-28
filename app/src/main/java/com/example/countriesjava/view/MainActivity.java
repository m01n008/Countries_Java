package com.example.countriesjava.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriesjava.R;
import com.example.countriesjava.model.CountryPojo;
import com.example.countriesjava.viewmodel.ListViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private ListViewModel viewModel;
    private RecyclerView countryRecyclerView;
    private List<CountryPojo> countryList = new ArrayList<>();
    private String token = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        bindObjects();

       // getNotifyToken();

        ObserveModel();



    }

//    private void getNotifyToken() {
//
//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
//            @Override
//            public void onComplete(@NonNull @NotNull Task<String> task) {
//                token = task.getResult();
//                Log.i("--notitoken ",token);
//            }
//        });
//    }


    private void ObserveModel() {

        viewModel.getCountryList().subscribe(new Observer<List<CountryPojo>>() {
            @Override
            public void onSubscribe(Disposable d) {


            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onNext(List<CountryPojo> value) {
                countryList = value;

            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError:", e.toString());
            }

            @Override
            public void onComplete() {
                countryRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                countryRecyclerView.setAdapter(new CountryListAdapter(countryList, getBaseContext(),token));

            }
        });


    }

    private void bindObjects() {

        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
    }

    private void bindViews() {

        countryRecyclerView = findViewById(R.id.countryRecyclerView);


    }


}