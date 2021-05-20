package com.example.countriesjava.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriesjava.R;
import com.example.countriesjava.model.CountryPojo;
import com.example.countriesjava.viewmodel.ListViewModel;
import com.example.countriesjava.util.Notification;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.example.countriesjava.util.Notification.getNotificationInstance;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private List<CountryPojo> countryList;
    private ListViewModel viewModel;
    private Context context;
    private String token = "";

    public CountryListAdapter(List<CountryPojo> countryList, Context context,String token) {
        this.countryList = countryList;
        this.context = context;
        this.token = token;
    }


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
                getNotificationInstance().SendNotification(token,"Welcome to Moin's Cypher World"
                        ,"Say Marhaba to: "+countryList.get(position).getName(),context);

            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Capital;
        ImageView Flag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.Name);
            Capital = itemView.findViewById(R.id.Capital);

        }
    }

}
