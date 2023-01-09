package com.example.projectapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class about_us extends AppCompatActivity {
    ImageView btnwa, btnig,btnfc,btntwiter,btndt,btnwaojan,btnigojan,btnfbojan,btntwitterojan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        btnwa = findViewById(R.id.im_wa);
        btnfc = findViewById(R.id.im_fc);
        btnig = findViewById(R.id.im_ig);
        btntwiter = findViewById(R.id.im_twitter);
        btndt = findViewById(R.id.btn_dota);
        btnwaojan = findViewById(R.id.im_wea);
        btnigojan = findViewById(R.id.im_ige);
        btnfbojan = findViewById(R.id.im_fb);
        btntwitterojan = findViewById(R.id.im_twittere);

         btnwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "+6282176095404";

                Uri uri = Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s",number));
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String applink = "fb://page/237564710351658";
                String spackage = "com.facebook.katana";
                String Sweblink = "https://www.facebook.com/aderockysaputra";

                openLink(applink,spackage,Sweblink);
            }
        });
        btnig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sapplink = "https://www.instagram.com/aderocky_raa";
                String spackage = "com.instagram.android";


                openLink(sapplink,spackage,sapplink);
            }
        });
        btntwiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sapplink = "twitter://user?screen_name=AndroidCoding_";
                String spackage = "com.twitter.android";
                String sweblink = "https://twitter.com/aderocky";


                openLink(sapplink,spackage,sweblink);
            }
        });

        btndt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(about_us.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnwaojan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "+628979314697";

                Uri uri = Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s",number));
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btnfbojan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String applink = "fb://page/237564710351658";
                String spackage = "com.facebook.katana";
                String Sweblink = "https://www.facebook.com/muhammadfawzan";

                openLink(applink,spackage,Sweblink);
            }
        });
        btnigojan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sapplink = "https://www.instagram.com/fawzaaannn";
                String spackage = "com.instagram.android";


                openLink(sapplink,spackage,sapplink);
            }
        });
        btntwitterojan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sapplink = "twitter://user?screen_name=AndroidCoding_";
                String spackage = "com.twitter.android";
                String sweblink = "https://twitter.com/muhammadfawzan";


                openLink(sapplink,spackage,sweblink);
            }
        });

    }
    private void openLink(String applink, String spackage , String weblink){
        try{
            Uri uri = Uri.parse(applink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(spackage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
            Uri uri= Uri.parse(weblink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}