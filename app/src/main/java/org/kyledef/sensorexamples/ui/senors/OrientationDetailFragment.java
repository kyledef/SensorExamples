package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class OrientationDetailFragment extends SensorDetailFragment {

    public OrientationDetailFragment() {
        super();
        this.senorName = "Orientation";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.orientation_description);
    }
}
