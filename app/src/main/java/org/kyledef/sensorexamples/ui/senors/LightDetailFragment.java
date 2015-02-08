package org.kyledef.sensorexamples.ui.senors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.ui.SensorDetailFragment;

import java.util.List;

public class LightDetailFragment extends SensorDetailFragment implements SensorEventListener {
    SensorManager sensorManager;
    Sensor lightSensor;
    public LightDetailFragment() {
        super();
        this.senorName = "Light";
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.light_description);
        this.sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        this.lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }
    public void sensorStart(){
        if (lightSensor != null){
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getActivity(), "No Light Sensor Detected", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float lux = sensorEvent.values[0];
        ((TextView) getActivity().findViewById(R.id.result_line_1)).setText("Light Intensity: " + lux);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
