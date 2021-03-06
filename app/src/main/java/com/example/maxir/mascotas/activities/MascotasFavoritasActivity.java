package com.example.maxir.mascotas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.maxir.mascotas.pojo.Mascota;
import com.example.maxir.mascotas.adapters.MascotasAdapter;
import com.example.maxir.mascotas.R;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter viewAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        toolbar = (Toolbar) findViewById(R.id.action_bar_no_star);

        // Enable go back button in action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(false);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // set DataSet mascotas
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(15,"Gato", 5, R.drawable.gato));
        mascotas.add(new Mascota(16,"Perro", 7, R.drawable.perro));
        mascotas.add(new Mascota(17,"Flamingo", 10, R.drawable.flamingo));
        mascotas.add(new Mascota(18,"Hamster", 7,R.drawable.hamster));
        mascotas.add(new Mascota(19,"Mono", 2, R.drawable.mono));


        // specify an adapter (see also next example)
        viewAdapter = new MascotasAdapter(mascotas, this.getParent());
        recyclerView.setAdapter(viewAdapter);
    }
}
