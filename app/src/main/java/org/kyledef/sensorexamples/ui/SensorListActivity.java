package org.kyledef.sensorexamples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.utils.SensorFactory;

public class SensorListActivity extends FragmentActivity
        implements SensorListFragment.Callbacks {

    private boolean mTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        if (findViewById(R.id.sensor_detail_container) != null) {
            mTwoPane = true;
            ((SensorListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.sensor_list))
                    .setActivateOnItemClick(true);
        }
    }

    /**
     * Callback method from {@link SensorListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(int id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putInt(SensorDetailFragment.ARG_ITEM_ID, id);

//            SensorDetailFragment fragment = new SensorDetailFragment();
            Fragment fragment = SensorFactory.getInstance().getSensorFragment(id);

            fragment.setArguments(arguments);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.sensor_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, SensorDetailActivity.class);
            detailIntent.putExtra(SensorDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
