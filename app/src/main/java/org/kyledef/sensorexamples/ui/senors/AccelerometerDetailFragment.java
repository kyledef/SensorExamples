package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.model.DBHelper;
import org.kyledef.sensorexamples.model.manager.AccelerometerModelManager;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class AccelerometerDetailFragment extends SensorDetailFragment {

    public AccelerometerDetailFragment() {
        super();
        this.senorName = "Accelerometer";
        this.sensorType = Sensor.TYPE_ACCELEROMETER;

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.accelerometer_description);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        super.onSensorChanged(sensorEvent);

        DBHelper dbh = new DBHelper(getActivity());
        AccelerometerModelManager acmm = new AccelerometerModelManager(dbh.getWritableDatabase());
        if (acmm.saveEntry(sensorEvent.values))
            Log.d("AccelerometerDetail", "Database Saved");
    }





}
