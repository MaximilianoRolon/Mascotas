package com.example.maxir.mascotas.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MiMascotaAdapter extends RecyclerView.Adapter<MiMascotaAdapter.MascotasViewHolder> {
    private ArrayList<Mascota> mascotas;
    public View v;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_mi_mascotas;
        public ImageView iv_mi_mascotas;
        public TextView tv_mi_mascotas_raiting;
        public MascotasViewHolder(View v) {
            super(v);
            iv_mi_mascotas = v.findViewById(R.id.iv_mi_mascotas);
            tv_mi_mascotas_raiting = v.findViewById(R.id.tv_mi_mascotas_raiting);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MiMascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MiMascotaAdapter.MascotasViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        // create a new view
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.mi_mascota_recycler_view, parent, false);

        MascotasViewHolder vh = new MascotasViewHolder(contactView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MascotasViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.iv_mi_mascotas.setImageResource(mascotas.get(position).getFoto());
        holder.tv_mi_mascotas_raiting.setText(Integer.toString(mascotas.get(position).getRaiting()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}