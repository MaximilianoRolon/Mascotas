package com.example.maxir.mascotas.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.mailer.GMailSender;

public class ContactoActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
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

    public void sendMessage(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                EditText contactoNombre   = (EditText)findViewById(R.id.contacto_nombre);
                EditText contactoEmail   = (EditText)findViewById(R.id.contacto_email);
                EditText contactoMensaje   = (EditText)findViewById(R.id.contacto_mensaje);
                GMailSender gmailSender = new GMailSender("ttestfrommail@gmail.com", "PepeHands");
                try {
                    gmailSender.sendMail( "Mensaje del usuario: " + contactoNombre.getText().toString() + " cuyo mail es: " + contactoEmail.getText().toString(),  contactoMensaje.getText().toString(), "ttestfrommail@gmail.com",  "ttestfrommail@gmail.com");
                    Log.i("MAILLOG", "Mail sent ok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(this, "Mensaje enviado!",
                Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
}
