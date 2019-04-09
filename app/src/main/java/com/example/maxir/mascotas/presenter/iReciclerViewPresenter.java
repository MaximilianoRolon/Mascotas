package com.example.maxir.mascotas.presenter;

import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface iReciclerViewPresenter {
    public void createMascotas();
    public ArrayList<Mascota> obtenerMascotas();
    public void darLikeMascota(int id);
    public int obtenerLikesMascota(int id);
}
