package com.example.maxir.mascotas.pojo;

public class Mascota{

    private int id;
    private String nombre;
    private int raiting;
    private int foto;

    public Mascota(int id, String nombre, int raiting, int foto){
        this.id = id;
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public int getFoto() {
        return foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
