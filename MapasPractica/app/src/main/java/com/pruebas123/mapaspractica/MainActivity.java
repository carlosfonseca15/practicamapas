package com.pruebas123.mapaspractica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivCiudad, ivPlaya, ivSelva, ivmontana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miactionbar);
        miActionBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ivCiudad = (ImageView) findViewById(R.id.ivCiudad);
        ivCiudad.setOnClickListener(this);
        ivPlaya = (ImageView) findViewById(R.id.ivPlaya);
        ivPlaya.setOnClickListener(this);
        ivSelva = (ImageView) findViewById(R.id.ivSelva);
        ivSelva.setOnClickListener(this);
        ivmontana = (ImageView) findViewById(R.id.ivmontana);
        ivmontana.setOnClickListener(this);

    }

    public void irMapa(String opcion){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra(getResources().getString(R.string.popcion), opcion);
        startActivity(i);

    }

    @Override
    public void onClick(View view) {
        Log.e("Err", "entra");
       String opcion = "0";
       switch (view.getId()) {
           case R.id.ivCiudad:
               opcion = "1";
               Log.e("Err", "uno");
               break;
           case R.id.ivPlaya:
               opcion = "2";
               Log.e("Err", "dos");
               break;
           case R.id.ivSelva:
               opcion = "3";
               Log.e("Err", "tres");
               break;
           case R.id.ivmontana:
               opcion = "4";
               Log.e("Err", "cuatro");
               break;
       }

       irMapa(opcion);

    }
}