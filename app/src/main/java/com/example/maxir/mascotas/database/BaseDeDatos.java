package com.example.maxir.mascotas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper{

    private final String DATABASE_NAME = "Mascotas";
    private final int DATABASE_VERSION = 1;
    private final String TABLE_NAME = "Mascota";
    private final String COLUMNA_ID = "id";
    private final String COLUMNA_NOMBRE = "nombre";
    private final String COLUMNA_RAITING = "raiting";
    private final String COLUMNA_FOTO = "foto";
    private final Context context;

    public BaseDeDatos(Context context) {
        super(context, "Mascotas", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_instruction = "CREATE TABLE " + TABLE_NAME + "(" + COLUMNA_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMNA_NOMBRE + " TEXT, " + COLUMNA_RAITING + " INTEGER, " + COLUMNA_FOTO + " TEXT )";
        db.execSQL(sql_instruction);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createMascotas(){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME,null);

        if (!cursor.moveToNext()) {

            ArrayList<ContentValues> contentValuesArray = new ArrayList<ContentValues>();

            ContentValues contentValues;

            contentValues = new ContentValues();
            contentValues.put(COLUMNA_RAITING, 5);
            contentValues.put(COLUMNA_NOMBRE, "Gato");
            contentValues.put(COLUMNA_FOTO, R.drawable.gato);
            contentValuesArray.add(contentValues);

            contentValues = new ContentValues();
            contentValues.put(COLUMNA_RAITING, 7);
            contentValues.put(COLUMNA_NOMBRE, "Perro");
            contentValues.put(COLUMNA_FOTO, R.drawable.perro);
            contentValuesArray.add(contentValues);

            contentValues = new ContentValues();
            contentValues.put(COLUMNA_RAITING, 10);
            contentValues.put(COLUMNA_NOMBRE, "Flamingo");
            contentValues.put(COLUMNA_FOTO, R.drawable.flamingo);
            contentValuesArray.add(contentValues);

            contentValues = new ContentValues();
            contentValues.put(COLUMNA_RAITING, 9);
            contentValues.put(COLUMNA_NOMBRE, "Hamster");
            contentValues.put(COLUMNA_FOTO, R.drawable.hamster);
            contentValuesArray.add(contentValues);

            contentValues = new ContentValues();
            contentValues.put(COLUMNA_RAITING, 9);
            contentValues.put(COLUMNA_NOMBRE, "Mono");
            contentValues.put(COLUMNA_FOTO, R.drawable.mono);
            contentValuesArray.add(contentValues);


            for (ContentValues tmp : contentValuesArray) {
                db.insert(TABLE_NAME, null, tmp);
            }

        }

        db.close();
    }

    public ArrayList<Mascota> obtenerMascotas() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME,null);

        int idMascota;
        String nombreMascota;
        int raitingMascota;
        String fotoMascota;

        ArrayList<Mascota> mascotas = new ArrayList<>();

        while(cursor.moveToNext()){
            idMascota = cursor.getInt(0);
            nombreMascota = cursor.getString(1);
            raitingMascota = cursor.getInt(2);
            fotoMascota = cursor.getString(3);
            mascotas.add(new Mascota(idMascota, nombreMascota, raitingMascota,Integer.parseInt(fotoMascota)));
        }
        db.close();
        return mascotas;
    }

    public void darLikeMascota(int id) {
        ContentValues data=new ContentValues();
        data.put(COLUMNA_RAITING,this.obtenerLikesMascota(id) + 1);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_NAME, data, "id=" + id, null);
        db.close();
    }

    public int obtenerLikesMascota(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id + " ", null);
        cursor.moveToNext();
        int raitingMascota = cursor.getInt(2);
        db.close();
        return raitingMascota;
    }
}
