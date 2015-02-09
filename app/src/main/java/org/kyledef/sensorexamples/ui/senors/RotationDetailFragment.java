package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class RotationDetailFragment extends SensorDetailFragment implements SensorEventListener {

    public RotationDetailFragment() {
        super();
        this.senorName = "Rotation Vector";
        this.sensorType = Sensor.TYPE_ROTATION_VECTOR;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.rotation_vector_description);
    }
}
