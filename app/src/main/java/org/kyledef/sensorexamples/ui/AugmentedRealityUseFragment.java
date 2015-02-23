package org.kyledef.sensorexamples.ui;

import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.kyledef.sensorexamples.R;

import java.util.ArrayList;

/**
 * Created by kyle on 2/22/15.
 */
public class AugmentedRealityUseFragment extends BaseActivity implements GoogleApiClient.ConnectionCallbacks,  GoogleApiClient.OnConnectionFailedListener,OnClickBeyondarObjectListener {

    private BeyondarFragmentSupport mBeyondarFragment;
    private World world;
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_augmented_reality_use);
        mBeyondarFragment = (BeyondarFragmentSupport)getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);

        if (this.mBeyondarFragment != null)
            mBeyondarFragment.setOnClickBeyondarObjectListener(this);
        else
            Toast.makeText(this, "Unable to find fragment", Toast.LENGTH_SHORT).show();

        pullWorld();
    }


    public void pullWorld(){
        world = new World(this);
//        world.setDefaultBitmap(R.drawable.gps_not_fixed);

//        https://developer.android.com/training/location/retrieve-current.
        client = (new GoogleApiClient.Builder(this))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connection connected", Toast.LENGTH_SHORT).show();

        Location mLocation = LocationServices.FusedLocationApi.getLastLocation(client);
        if (mLocation != null){
            world.setGeoPosition(mLocation.getLatitude(), mLocation.getLongitude());

            GeoObject [] objArrs = new GeoObject[10];
            for( int i = 0; i < objArrs.length; i++){
                GeoObject obj = new GeoObject();
                obj.setImageResource(R.drawable.gps_not_fixed);
                obj.setGeoPosition(mLocation.getLatitude(), mLocation.getLongitude());
                obj.setName("OBJ-"+i);
                world.addBeyondarObject(obj);
            }
        }
        if (this.mBeyondarFragment != null)
            this.mBeyondarFragment.setWorld(world);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> beyondarObjects) {
        Toast.makeText(this, "Clicked on: " + beyondarObjects.get(0).getName(), Toast.LENGTH_LONG).show();
    }
}
