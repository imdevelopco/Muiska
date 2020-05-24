package com.example.muiska.views;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.muiska.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mapa;
    private  LatLng locationMuisca,lagunaGuatavita,lagunaSiecha,lagunaTeusaca,lagunaGuasca,lagunaUbaque,
                    topLeft,topRight,bottomLeft,bottomRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public Bitmap smallMarker(int drawable){
        int height = 150;
        int width = 150;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(drawable);
        Bitmap b=bitmapdraw.getBitmap();
        return  Bitmap.createScaledBitmap(b, width, height, false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        locationMuisca = new LatLng(5.4185, -73.421);

        lagunaGuatavita = new LatLng(4.977590, -73.774952);
        lagunaGuasca = new LatLng(4.909936, -73.718038);
        lagunaSiecha = new LatLng(4.762990, -73.850289);
        lagunaTeusaca = new LatLng(4.560444, -74.022162);
        lagunaUbaque = new  LatLng(4.499780, -73.935565);


        mapa.addMarker(new MarkerOptions().position(lagunaGuatavita).title("Laguna Guatavita").snippet("Sesquilé, Cundinamarca").icon(BitmapDescriptorFactory.fromBitmap(smallMarker(R.drawable.lagomuiska))));
        mapa.addMarker(new MarkerOptions().position(lagunaGuasca).title("Laguna Guasca").snippet("Entre Guasca y Guatavita, Cundinamarca").icon(BitmapDescriptorFactory.fromBitmap(smallMarker(R.drawable.lagomuiska))));
        mapa.addMarker(new MarkerOptions().position(lagunaSiecha).title("Laguna Siecha").snippet("Guasca, Cundinamarca").icon(BitmapDescriptorFactory.fromBitmap(smallMarker(R.drawable.lagomuiska))));
        mapa.addMarker(new MarkerOptions().position(lagunaTeusaca).title("Laguna Teusacá").snippet("Vía Choachí, Cundinamarca").icon(BitmapDescriptorFactory.fromBitmap(smallMarker(R.drawable.lagomuiska))));
        mapa.addMarker(new MarkerOptions().position(lagunaUbaque).title("Laguna Ubaqué").snippet("Entre Choachí y Ubaqué, Cundinamarca").icon(BitmapDescriptorFactory.fromBitmap(smallMarker(R.drawable.lagomuiska))));
        mapa.addMarker(new MarkerOptions().position(locationMuisca).title("Territorio Muisca").snippet("Altiplano cundiboyacense")
            .icon(BitmapDescriptorFactory.fromBitmap(smallMarker(R.drawable.muiscamarker))));
        mapa.moveCamera(CameraUpdateFactory.newLatLng(lagunaUbaque));
        mapa.animateCamera(CameraUpdateFactory.zoomTo((float) 9.49),1000,null);
        mapa.getUiSettings().setMapToolbarEnabled(false);
        mapa.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                                         @Override
                                         public void onCameraIdle() {
                                             locationMuisca = new LatLng(mapa.getCameraPosition().target.latitude,mapa.getCameraPosition().target.longitude);
                                             topLeft = new LatLng(12.894122243083283,-79.66413816064596);
                                             topRight = new LatLng(12.894122243083283,-66.29967233687639);
                                             bottomLeft = new LatLng(-4.835118627788749,-79.66413816064596);
                                             bottomRight = new LatLng(-4.835118627788749,-66.29967233687639);
                                             LatLngBounds limits = new LatLngBounds.Builder().include(lagunaUbaque).include(topLeft).include(bottomLeft)
                                                     .include(topRight).include(bottomRight).build();
                                             Bitmap imagenFondo = BitmapFactory.decodeResource(getResources(), R.drawable.map);
                                             BitmapDescriptor imgFondoMap = BitmapDescriptorFactory.fromBitmap(imagenFondo);
                                             GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
                                             groundOverlayOptions.image(imgFondoMap);
                                             groundOverlayOptions.positionFromBounds(limits);
                                             groundOverlayOptions.transparency(0.1F);
                                             mapa.addGroundOverlay(groundOverlayOptions);
                                         }
                                     }
        );
    }

}
