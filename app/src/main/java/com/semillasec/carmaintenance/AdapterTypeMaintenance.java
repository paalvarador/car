package com.semillasec.carmaintenance;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 02/07/15.
 */
public class AdapterTypeMaintenance extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<TypeMaintenance> items;

    public AdapterTypeMaintenance(Activity activity, ArrayList<TypeMaintenance> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_layout, null);
        }

        // Se crea un objeto TypeMaintenance
        TypeMaintenance typeMaintenance = items.get(position);

        // Se rellena la fotografía
        ImageView ivIcon = (ImageView) view.findViewById(R.id.icon);
        ivIcon.setImageDrawable(typeMaintenance.getIcon());

        // Se rellena el nombre
        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        tvTitle.setText(typeMaintenance.getTitle());

        // Se rellena la descripción
        TextView tvDescription = (TextView) view.findViewById(R.id.description);
        tvDescription.setText(typeMaintenance.getDescription());

        // Se retorna la vista
        return view;
    }
}
