package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class GravityDetailFragment extends SensorDetailFragment {

    public GravityDetailFragment() {
        super();
        this.senorName = "Gravity";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.gravity_description);
    }
}
