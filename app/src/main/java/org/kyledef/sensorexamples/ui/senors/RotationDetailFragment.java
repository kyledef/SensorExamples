package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class RotationDetailFragment extends SensorDetailFragment {

    public RotationDetailFragment() {
        super();
        this.senorName = "Rotation Vector";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.rotation_vector_description);
    }

}
