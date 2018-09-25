package com.example.maxir.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewManager;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

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


    public void estrella_favoritos_click(View view) {
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

    public void showMainPopupMenu (View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main_popup_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intent1 = new Intent(this, ContactoActivity.class);
                startActivity(intent1);
                return true;
            case R.id.mAcercaDe:
                Intent intent2 = new Intent(this, AcercaDeActivity.class);
                startActivity(intent2);
                return true;
            default:
                return false;
        }
    }
}
