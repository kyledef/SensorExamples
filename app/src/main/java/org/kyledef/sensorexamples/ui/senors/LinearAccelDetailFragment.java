package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class LinearAccelDetailFragment extends SensorDetailFragment {

    public LinearAccelDetailFragment() {
        super();
        this.senorName = "Linear Acceleration";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.linear_accelerometer_description);
    }
}
