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
import com.google.android.gms.maps.model.VisibleRegion;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mapa;
    private  LatLng locationMuisca,topLeft,topRight,bottomLeft,bottomRight, centroMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        int height = 150;
        int width = 150;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.muiscamarker);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        mapa = googleMap;
        locationMuisca = new LatLng(5.4185, -73.421);
        centroMapa = new LatLng(4.390652, -72.531905);
        /*Casanare

*/
        mapa.addMarker(new MarkerOptions().position(locationMuisca).title("Territorio Muisca").snippet("Altiplano cundiboyacense")
            .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        mapa.moveCamera(CameraUpdateFactory.newLatLng(centroMapa));

        mapa.animateCamera(CameraUpdateFactory.zoomTo((float) 5.49),1000,null);
        mapa.getUiSettings().setMapToolbarEnabled(false);
        mapa.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                                         @Override
                                         public void onCameraIdle() {
                                             locationMuisca = new LatLng(mapa.getCameraPosition().target.latitude,mapa.getCameraPosition().target.longitude);
                                             topLeft = new LatLng(12.894122243083283,-79.66413816064596);
                                             topRight = new LatLng(12.894122243083283,-66.29967233687639);
                                             bottomLeft = new LatLng(-4.835118627788749,-79.66413816064596);
                                             bottomRight = new LatLng(-4.835118627788749,-66.29967233687639);
                                             LatLngBounds limits = new LatLngBounds.Builder().include(centroMapa).include(topLeft).include(bottomLeft)
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
