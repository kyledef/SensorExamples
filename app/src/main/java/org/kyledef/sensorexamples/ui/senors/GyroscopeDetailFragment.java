package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class GyroscopeDetailFragment extends SensorDetailFragment {
    public GyroscopeDetailFragment() {
        super();
        this.senorName = "Gyroscope";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.gyroscop_description);
    }
}
