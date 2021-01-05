package com.pruebas123.mapaspractica;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String opcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miactionbar);
        miActionBar.setTitleTextColor(getResources().getColor(R.color.white));


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();
        opcion = bundle.getString(getResources().getString(R.string.popcion));

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(4.711977106746532, -74.03406500816347);
        LatLng punto;
        String titulo;
        switch (opcion) {
            case "1":
                punto = new LatLng(6.200629499027874, -75.56677579879762);
                titulo = "Ciudad Medellin";
                break;
            case "2":
                punto = new LatLng(11.328369363799524, -74.07713055610658);
                titulo = "Playa Cristal";
                break;
            case "3":
                punto = new LatLng(-4.213487964749626, -69.94364261627199);
                titulo = "Selva Leticia";
                break;
            case "4":
                punto = new LatLng(4.892657841008781, -75.31904697418214);
                titulo = "Montaña Nevado del Ruiz";
                break;
            default:
                punto = new LatLng(4.598412757514107, -74.0755319595337);
                titulo = "Bogota ";
        }


        mMap.addMarker(new MarkerOptions().position(punto).title(titulo)
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.7f));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 1000, null);
    }
}