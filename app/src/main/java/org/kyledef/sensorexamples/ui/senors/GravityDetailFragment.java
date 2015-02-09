package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.model.DBHelper;
import org.kyledef.sensorexamples.model.manager.AccelerometerModelManager;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class GravityDetailFragment extends SensorDetailFragment {

    public GravityDetailFragment() {
        super();
        this.senorName = "Gravity";
        this.sensorType = Sensor.TYPE_GRAVITY;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.gravity_description);
    }
}
