package com.example.maxir.mascotas.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.fragments.ReciclerViewFragment;
import com.example.maxir.mascotas.pojo.Mascota;
import com.example.maxir.mascotas.presenter.ReciclerViewPresenter;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder> {
    private Activity activity;
    private ArrayList<Mascota> mascotas;
    public View v;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_mascotas;
        public ImageView iv_mascotas;
        public TextView tv_mascotas_raiting;
        public ImageView likeImg;
        public MascotasViewHolder(View v) {
            super(v);
            tv_mascotas = v.findViewById(R.id.tv_mascotas);
            iv_mascotas = v.findViewById(R.id.iv_mascotas);
            tv_mascotas_raiting = v.findViewById(R.id.tv_mascotas_raiting);
            likeImg = v.findViewById(R.id.likeImg);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MascotasAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MascotasAdapter.MascotasViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.mascotas_recycler_view, parent, false);

        MascotasViewHolder vh = new MascotasViewHolder(contactView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MascotasViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tv_mascotas.setText(mascotas.get(position).getNombre());
        holder.iv_mascotas.setImageResource(mascotas.get(position).getFoto());
        holder.tv_mascotas_raiting.setText(Integer.toString(mascotas.get(position).getRaiting()));
        holder.likeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a:" + mascotas.get(position).getNombre(), Toast.LENGTH_SHORT).show();


                ReciclerViewPresenter reciclerViewPresenter = new ReciclerViewPresenter(activity);
                reciclerViewPresenter.darLikeMascota(mascotas.get(position).getId());

                holder.tv_mascotas_raiting.setText(Integer.toString(reciclerViewPresenter.obtenerLikesMascota(mascotas.get(position).getId())));

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}