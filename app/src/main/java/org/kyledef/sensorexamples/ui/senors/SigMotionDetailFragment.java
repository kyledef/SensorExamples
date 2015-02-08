package org.kyledef.sensorexamples.ui.senors;

import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;

public class SigMotionDetailFragment extends SensorDetailFragment {

    public SigMotionDetailFragment() {
        super();
        this.senorName = "Significant Motion";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.signif_motion_description);
    }

}
