package com.semillasec.carmaintenance;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 12/07/15.
 */
public class AdapterMaintenance extends RecyclerView.Adapter<AdapterMaintenance.MaintenanceViewHolder> {
    private List<Maintenance> maintenanceList;

    public AdapterMaintenance(List<Maintenance> maintenList){
        this.maintenanceList = maintenList;
    }

    @Override
    public int getItemCount() {
        return maintenanceList.size();
    }

    @Override
    public void onBindViewHolder(MaintenanceViewHolder holder, int position) {
        holder.name.setText(maintenanceList.get(position).get_name());
        holder.date.setText(maintenanceList.get(position).get_date());
    }

    @Override
    public AdapterMaintenance.MaintenanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_view_row, parent, false);

        MaintenanceViewHolder viewHolder = new MaintenanceViewHolder(itemView);
        return viewHolder;
    }

    public static class MaintenanceViewHolder extends RecyclerView.ViewHolder{
        public ImageView icon;
        public TextView name;
        public TextView date;

        public MaintenanceViewHolder(View itemView) {
            super(itemView);
            this.icon = (ImageView) itemView.findViewById(R.id.imgIcon);
            this.name = (TextView) itemView.findViewById(R.id.txtType);
            this.date = (TextView) itemView.findViewById(R.id.txtDate);
        }
    }
}
