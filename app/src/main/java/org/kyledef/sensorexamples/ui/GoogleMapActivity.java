package org.kyledef.sensorexamples.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.beyondar.android.plugin.googlemap.GoogleMapWorldPlugin;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.utils.ARHelper;

/**
 * Created by kyledef on 2/23/15.
 */
public class GoogleMapActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener{

    GoogleMap mMap;
    GoogleMapWorldPlugin mGoogleMapPlugin;
    World world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_google);

        mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mMap == null){
            Toast.makeText(this, "Unable to find Map Object", Toast.LENGTH_SHORT).show();
        }

        world = ARHelper.createDefaultWorld(this);
        mGoogleMapPlugin = new GoogleMapWorldPlugin(this);
        mGoogleMapPlugin.setGoogleMap(mMap);
        world.addPlugin(mGoogleMapPlugin);
        mMap.setOnMarkerClickListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mGoogleMapPlugin.getLatLng(), 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(19), 2000, null);

        GeoObject user = new GeoObject(1000l);
        user.setGeoPosition(world.getLatitude(), world.getLongitude());
        user.setImageResource(R.drawable.flag);
        user.setName("My position");
        world.addBeyondarObject(user);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        GeoObject geoObject = mGoogleMapPlugin.getGeoObjectOwner(marker);
        if (geoObject != null) {
            Toast.makeText(this,"Click on a marker owned by a GeoOject with the name: " + geoObject.getName(),Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
