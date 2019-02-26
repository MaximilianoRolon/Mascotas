package com.example.maxir.mascotas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.maxir.mascotas.R;

public class AcercaDeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }

    public void showMainPopupMenu (View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
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
