package org.kyledef.sensorexamples.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import org.kyledef.sensorexamples.utils.ARHelper;

public class AugmentedRealityUseFragment extends BaseActivity implements View.OnClickListener {

    private BeyondarFragmentSupport mBeyondarFragment;
    private World world;
    private GoogleApiClient client;
    private Button mShowMap;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_augmented_reality_use);
        mBeyondarFragment = (BeyondarFragmentSupport)getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);

        if (this.mBeyondarFragment != null) {
            world = ARHelper.createDefaultWorld(this);

            mBeyondarFragment.setWorld(world);
            mBeyondarFragment.showFPS(true);

            mShowMap = (Button)findViewById(R.id.showMapButton);
            if (mShowMap != null)mShowMap.setOnClickListener(this);

        }else
            Toast.makeText(this, "Unable to find fragment", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view == this.mShowMap) {
            Toast.makeText(this, "Selected the Show Map Button", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, GoogleMapActivity.class);
            startActivity(i);
        }
    }
}
