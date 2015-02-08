package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class MagneticFieldDetailFragment extends SensorDetailFragment {

    public MagneticFieldDetailFragment() {
        super();
        this.senorName = "Magnetic Field";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.magnetic_field_description);
    }
}
