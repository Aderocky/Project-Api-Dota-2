package com.example.projectapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mysongo;
    private BottomNavigationView btv_menu;
    private ImageButton imgHome , imgMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysongo= MediaPlayer.create(this,R.raw.rawr);
        mysongo.setVolume(100,100);
        mysongo.stop();
        mysongo.start();
        mysongo.setLooping(true);

        imgHome = findViewById(R.id.btn_dota);
        imgMenu = findViewById(R.id.btn_menu);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mysongo.stop();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
            }
        });
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, about_us.class);
                startActivity(intent);
            }
        });
        btv_menu = findViewById(R.id.bnv_pilihan);
        btv_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment FR;
                switch (item.getItemId()){
                    case R.id.menu_heroes:
                        bukafragment(new heroesFragment());
                        return true;
                    case R.id.menu_leagues:
                        bukafragment(new leaguesFragment());
                        return true;
                    case R.id.menu_teams:

                        bukafragment(new teamsFragment());

                        return true;
                }
                return false;
            }
        });
    }
    private void bukafragment (Fragment FR){
        FragmentManager Fm = getSupportFragmentManager();
        FragmentTransaction Ft = Fm.beginTransaction();
        Ft.replace(R.id.fl_container, FR);
        Ft.commit();
    }
    public void playIT(){
        mysongo.start();
    }
}