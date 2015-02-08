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


public class AccelerometerDetailFragment
        extends SensorDetailFragment
        implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelSensor;

    public AccelerometerDetailFragment() {
        super();
        this.senorName = "Accelerometer";

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.sensorDescription = getResources().getString(R.string.accelerometer_description);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void sensorStart(){

        if (accelSensor != null){
            //Register Listener
            sensorManager.registerListener(this,accelSensor,SensorManager.SENSOR_DELAY_NORMAL);
            changeRegisteredState(true);
            Toast.makeText(getActivity(), "Accelerometer Sensor Found", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "No Accelerometer Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void sensorToggle(){
        Toast.makeText(getActivity(), "Accelerometer Toggle Button Selected", Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(this);
        changeRegisteredState(false);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        ((TextView) getActivity().findViewById(R.id.result_line_1)).setText("X: " + x);
        ((TextView) getActivity().findViewById(R.id.result_line_2)).setText("Y: " + y);
        ((TextView) getActivity().findViewById(R.id.result_line_3)).setText("Z: " + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        ((TextView) getActivity().findViewById(R.id.result_line_4)).setText("Accuracy: " + i);
    }

    @Override
    public void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
        changeRegisteredState(false);
    }

}
