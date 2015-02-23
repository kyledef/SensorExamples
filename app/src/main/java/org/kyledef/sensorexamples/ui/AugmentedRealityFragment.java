package org.kyledef.sensorexamples.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kyledef.sensorexamples.R;

/**
 * Created by kyle on 2/22/15.
 */
public class AugmentedRealityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_augmented_reality_main, container, false);
        return rootView;
    }
}