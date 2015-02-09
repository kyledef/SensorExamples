package org.kyledef.sensorexamples.ui.senors;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class GPSDetailFragment extends SensorDetailFragment implements LocationListener {

    private LocationManager locationManager;

    public GPSDetailFragment() {
        super();
        this.senorName = "GPS Location";
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.gravity_description);
        locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        this.locationManager.removeUpdates(this);
        changeRegisteredState(false);
    }

    @Override
    public void sensorStart(){
        if (this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(getActivity(), "Reading Location from GPS Location", Toast.LENGTH_SHORT).show();
            this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            changeRegisteredState(true);
        }else{
            Toast.makeText(getActivity(), "Enable GPS and reattempt", Toast.LENGTH_SHORT).show();
            this.buildAlertMessageNoGps();
        }
    }

    @Override
    public void sensorToggle(){
        if (this.registered){
            this.locationManager.removeUpdates(this);
            changeRegisteredState(false);
        }else{
            sensorStart();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        ((TextView) getActivity().findViewById(R.id.result_line_1)).setText("Lat: " + location.getLatitude());
        ((TextView) getActivity().findViewById(R.id.result_line_2)).setText("Long: " + location.getLongitude());
        ((TextView) getActivity().findViewById(R.id.result_line_3)).setText("Alt: " + location.getAltitude());
        ((TextView) getActivity().findViewById(R.id.result_line_4)).setText("Accuracy: " + location.getAccuracy());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    //http://stackoverflow.com/questions/843675/how-do-i-find-out-if-the-gps-of-an-android-device-is-enabled
    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}
