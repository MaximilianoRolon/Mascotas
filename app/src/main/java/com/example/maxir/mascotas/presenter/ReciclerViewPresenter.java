package com.example.maxir.mascotas.presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.maxir.mascotas.database.BaseDeDatos;
import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class ReciclerViewPresenter implements iReciclerViewPresenter {

    BaseDeDatos baseDeDatos;
    Context context;

    public ReciclerViewPresenter(Context context){
        this.context = context;
        createMascotas();
    }

    public ArrayList<Mascota> obtenerMascotas(){
        baseDeDatos = new BaseDeDatos(this.context);
        ArrayList<Mascota> mascotas = baseDeDatos.obtenerMascotas();
        return mascotas;
    }


    @Override
    public void createMascotas() {
        baseDeDatos = new BaseDeDatos(this.context);
        baseDeDatos.createMascotas();

    }

    public void darLikeMascota(int id) {
        baseDeDatos = new BaseDeDatos(this.context);
        baseDeDatos.darLikeMascota(id);
    }

    public int obtenerLikesMascota(int id) {
        baseDeDatos = new BaseDeDatos(this.context);
        int likes = baseDeDatos.obtenerLikesMascota(id);
        return likes;
    }

}
