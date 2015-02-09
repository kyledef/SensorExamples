package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;

public class SigMotionDetailFragment extends SensorDetailFragment {

    public SigMotionDetailFragment() {
        super();
        this.senorName = "Significant Motion";
        this.sensorType = Sensor.TYPE_SIGNIFICANT_MOTION;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.signif_motion_description);
    }
}
