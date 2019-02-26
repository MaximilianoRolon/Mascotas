package com.example.maxir.mascotas.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.maxir.mascotas.adapters.MascotasAdapter;
import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.adapters.ViewPagerAdapter;
import com.example.maxir.mascotas.mailer.GMailSender;
import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter viewAdapter;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        layoutManager = new LinearLayoutManager(this);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);


    }


    public void estrella_favoritos_click(View view) {
        Intent intent = new Intent(this, MascotasFavoritasActivity.class);
        startActivity(intent);
    }

    public void showMainPopupMenu (View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main_popup_menu, popup.getMenu());
        popup.show();
        /*

        */
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
