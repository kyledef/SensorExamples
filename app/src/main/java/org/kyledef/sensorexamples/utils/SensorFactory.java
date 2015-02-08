package org.kyledef.sensorexamples.utils;

import android.support.v4.app.Fragment;

import org.kyledef.sensorexamples.ui.senors.AccelerometerDetailFragment;
import org.kyledef.sensorexamples.ui.senors.GravityDetailFragment;
import org.kyledef.sensorexamples.ui.senors.GyroscopeDetailFragment;
import org.kyledef.sensorexamples.ui.senors.LightDetailFragment;
import org.kyledef.sensorexamples.ui.senors.LinearAccelDetailFragment;
import org.kyledef.sensorexamples.ui.senors.MagneticFieldDetailFragment;
import org.kyledef.sensorexamples.ui.senors.OrientationDetailFragment;
import org.kyledef.sensorexamples.ui.senors.RotationDetailFragment;
import org.kyledef.sensorexamples.ui.senors.SigMotionDetailFragment;

public class SensorFactory {
    private static SensorFactory instance = null;

    private SensorFactory(){

    }
    public static SensorFactory getInstance(){
        if (instance == null)instance = new SensorFactory();
        return instance;
    }

    public Fragment getSensorFragment(int id){
        Fragment tempFrag = null;
        switch (id){
            case 0:
                tempFrag = new AccelerometerDetailFragment();
                break;
            case 1:
                tempFrag = new GravityDetailFragment();
                break;
            case 2:
                tempFrag = new GyroscopeDetailFragment();
                break;
            case 3:
                tempFrag = new LightDetailFragment();
                break;
            case 4:
                tempFrag = new LinearAccelDetailFragment();
                break;
            case 5:
                tempFrag = new MagneticFieldDetailFragment();
                break;
            case 6:
                tempFrag = new OrientationDetailFragment();
                break;
            case 7:
                tempFrag = new RotationDetailFragment();
                break;
            case 8:
                tempFrag = new SigMotionDetailFragment();
                break;
        }
        return tempFrag;
    }
}
