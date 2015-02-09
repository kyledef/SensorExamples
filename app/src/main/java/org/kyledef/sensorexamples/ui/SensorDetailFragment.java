package org.kyledef.sensorexamples.ui;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.kyledef.sensorexamples.R;

/**
 * A fragment representing a single Sensor detail screen.
 * This fragment is either contained in a {@link SensorListActivity}
 * in two-pane mode (on tablets) or a {@link SensorDetailActivity}
 * on handsets.
 */
public abstract class SensorDetailFragment extends Fragment implements SensorEventListener {

    public static final String ARG_ITEM_ID = "item_id";
    private int pos = -1;
    protected String senorName;
    protected String sensorDescription;
    protected boolean registered = false;
    protected ToggleButton togBtn;

    protected SensorManager sensorManager;
    protected Sensor sensor;
    protected int sensorType;

    public SensorDetailFragment() {
        senorName = "Sensor";
        sensorDescription = "Description of the Sensor";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            pos = getArguments().getInt(ARG_ITEM_ID);
        }
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(this.sensorType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sensor_detail, container, false);
        ((TextView) rootView.findViewById(R.id.sensor_detail)).setText(senorName);
        ((TextView) rootView.findViewById(R.id.sensor_description)).setText(sensorDescription);

        ((Button)rootView.findViewById(R.id.read_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorStart();
            }
        });

        togBtn = (ToggleButton)rootView.findViewById(R.id.background_button);
        togBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorToggle();
            }
        });
        togBtn.setChecked(registered);

        return rootView;
    }

    @Override
    public void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
        changeRegisteredState(false);
    }

    public void sensorStart(){
        if (sensor != null){//Register Listener
            sensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
            changeRegisteredState(true);
            Toast.makeText(getActivity(), this.senorName +" Found", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "No "+ this.senorName +" Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void sensorToggle(){
        Toast.makeText(getActivity(), "Toggle Button Selected for " + this.senorName, Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(this);
        changeRegisteredState(false);
    }

    public void changeRegisteredState(boolean state){
        registered = state;
        togBtn.setChecked(registered);
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


}
