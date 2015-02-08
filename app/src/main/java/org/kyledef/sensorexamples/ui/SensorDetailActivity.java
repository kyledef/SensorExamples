package org.kyledef.sensorexamples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.utils.SensorFactory;


/**
 * An activity representing a single Sensor detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link SensorListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link SensorDetailFragment}.
 */
public class SensorDetailActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show the Up button in the action bar.
        if (savedInstanceState == null) {
            int pos = getIntent().getIntExtra(SensorDetailFragment.ARG_ITEM_ID, -1);

            Bundle arguments = new Bundle();
            arguments.putInt(SensorDetailFragment.ARG_ITEM_ID, pos);

//            SensorDetailFragment fragment = new SensorDetailFragment();
            Fragment fragment = SensorFactory.getInstance().getSensorFragment(pos);

            fragment.setArguments(arguments);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.sensor_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, SensorListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
