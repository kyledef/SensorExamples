package org.kyledef.sensorexamples.ui.senors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;


public class MagneticFieldDetailFragment extends SensorDetailFragment {

    public MagneticFieldDetailFragment() {
        super();
        this.senorName = "Magnetic Field";
        this.sensorType = Sensor.TYPE_MAGNETIC_FIELD;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.magnetic_field_description);
    }

}
