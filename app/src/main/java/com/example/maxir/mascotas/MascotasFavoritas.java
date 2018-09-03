package com.example.maxir.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

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
        mascotas.add(new Mascota("Gato", 5, R.drawable.gato));
        mascotas.add(new Mascota("Perro", 7, R.drawable.perro));
        mascotas.add(new Mascota("Flamingo", 10, R.drawable.flamingo));
        mascotas.add(new Mascota("Hamster", 7,R.drawable.hamster));
        mascotas.add(new Mascota("Mono", 2, R.drawable.mono));


        // specify an adapter (see also next example)
        viewAdapter = new MascotasAdapter(mascotas);
        recyclerView.setAdapter(viewAdapter);
    }
}
