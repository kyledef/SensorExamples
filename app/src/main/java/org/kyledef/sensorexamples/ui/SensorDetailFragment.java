package org.kyledef.sensorexamples.ui;

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
public class SensorDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private int pos = -1;
    protected String senorName;
    protected String sensorDescription;
    protected boolean registered = false;
    ToggleButton togBtn;

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

//        if (pos != -1) {
//            String [] sensorList = getResources().getStringArray(R.array.sensorList);
//            ((TextView) rootView.findViewById(R.id.sensor_detail)).setText(sensorList[pos]);
//        }
        return rootView;
    }

    public void sensorStart(){
        Toast.makeText(getActivity(), "Sensor Start Button Selected", Toast.LENGTH_SHORT).show();
    }

    public void sensorToggle(){
        Toast.makeText(getActivity(), "Sensor Toggle Button Selected", Toast.LENGTH_SHORT).show();
    }

    public void changeRegisteredState(boolean state){
        registered = state;
        togBtn.setChecked(registered);
    }
}
