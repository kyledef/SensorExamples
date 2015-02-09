package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class OrientationDetailFragment extends SensorDetailFragment implements SensorEventListener {

    public OrientationDetailFragment() {
        super();
        this.senorName = "Orientation";
        this.sensorType = Sensor.TYPE_ORIENTATION;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.orientation_description);
    }
}
