package kz.abcsoft.apteka.map;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import kz.abcsoft.apteka.R;

public class MapsActivity extends FragmentActivity {


    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar)findViewById(R.id.map_toolbar) ;
        toolbar.setTitle(R.string.nav_menu_item_near_apteki);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
//        mMap.addMarker(new MarkerOptions().position(new LatLng(42.31854237, 69.5962429)).title("Marker"));

        mMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location myLocation = locationManager.getLastKnownLocation(provider);
        double myLatitude = myLocation.getLatitude();
        double myLongitude = myLocation.getLongitude();
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_AZURE
        ) ;
        mMap.addMarker(new MarkerOptions().position(new LatLng(myLatitude, myLongitude))
                .icon(bitmapDescriptor)
                .title("Я нахожусь здесь")) ;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(myLatitude, myLongitude))
                .zoom(13)
                .build() ;
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition) ;
        mMap.animateCamera(cameraUpdate);

        mMap.addMarker(new MarkerOptions().position(new LatLng(42.31854237, 69.5962429)).title("Аптека 1"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.33306634279456, 69.58523947745562)).title("Аптека 2"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.337768136670306, 69.59050666540861)).title("Аптека 3"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.33212103432582, 69.5817157253623)).title("Аптека 4"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.323667401903194, 69.58151590079069)).title("Аптека 5"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.317695758479736, 69.5814773440361)).title("Аптека 6"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.313774428866246, 69.58416223526001)).title("Аптека 7"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(42.32053724959474, 69.58785999566317)).title("Аптека 8"));




//---------------------------
//        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker").snippet("Snippet"));
//
//        // Enable MyLocation Layer of Google Map
//        mMap.setMyLocationEnabled(true);
//
//        // Get LocationManager object from System Service LOCATION_SERVICE
//        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//
//        // Create a criteria object to retrieve provider
//        Criteria criteria = new Criteria();
//
//        // Get the name of the best provider
//        String provider = locationManager.getBestProvider(criteria, true);
//
//        // Get Current Location
//        Location myLocation = locationManager.getLastKnownLocation(provider);
//
//        // set map type
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//
//        // Get latitude of the current location
//        double latitude = myLocation.getLatitude();
//
//        // Get longitude of the current location
//        double longitude = myLocation.getLongitude();
//
//        // Create a LatLng object for the current location
//        LatLng latLng = new LatLng(latitude, longitude);
//
//        // Show the current location in Google Map
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//
//        // Zoom in the Google Map
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!").snippet("Consider yourself located"));


    }
}
