package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class GyroscopeDetailFragment extends SensorDetailFragment {
    public GyroscopeDetailFragment() {
        super();
        this.senorName = "Gyroscope";
        this.sensorType = Sensor.TYPE_GYROSCOPE;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.gyroscop_description);
    }
}
