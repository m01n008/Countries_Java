package com.example.countriesjava.view;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.example.countriesjava.R;
import com.example.countriesjava.model.CountryPojo;
import com.example.countriesjava.viewmodel.ListViewModel;

import java.util.List;

import static com.example.countriesjava.util.Notification.getNotificationInstance;
import static com.example.countriesjava.util.Util.getProgressBarDrawable;
import static com.example.countriesjava.util.Util.loadImage;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private List<CountryPojo> countryList;
    private ListViewModel viewModel;
    private Context context;
    private String token = "";

    public CountryListAdapter(List<CountryPojo> countryList, Context context, String token) {
        this.countryList = countryList;
        this.context = context;
        this.token = token;
    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countryitem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.Name.setText(countryList.get(position).getName());
        holder.Capital.setText(countryList.get(position).getCapital());
        holder.Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNotificationInstance().SendNotification(token, "Welcome to Moin's Cypher World"
                        , "Say Marhaba to: " + countryList.get(position).getName(), context);

            }
        });
        loadImage(holder.Flag, countryList.get(position).getFlag(), holder.circularProgressDrawable);

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Capital;
        ImageView Flag;
        CircularProgressDrawable circularProgressDrawable;

        @RequiresApi(api = Build.VERSION_CODES.Q)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.Name);
            Capital = itemView.findViewById(R.id.Capital);
            Flag = itemView.findViewById(R.id.Flag);
            circularProgressDrawable = getProgressBarDrawable(itemView.getContext());


        }
    }

}
