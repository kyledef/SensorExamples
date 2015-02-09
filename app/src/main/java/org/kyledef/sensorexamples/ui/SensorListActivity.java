package org.kyledef.sensorexamples.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import org.kyledef.sensorexamples.R;
import org.kyledef.sensorexamples.model.DBHelper;
import org.kyledef.sensorexamples.utils.PrefUtils;
import org.kyledef.sensorexamples.utils.SensorFactory;

public class SensorListActivity extends FragmentActivity
        implements SensorListFragment.Callbacks {

    private boolean mTwoPane = false;
    public static final String ACTIVITY_TAG = "SensorListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        // Is this the first time
        if (PrefUtils.isFirstUse(this)){
            Log.d(ACTIVITY_TAG, "Running for the First Time");
            // Create database in an AsyncTask
            new SetupDatabase().execute(this);
            // Set the first time so to ensure the code to not run
            PrefUtils.setFirstUse(this);
        }else
            Log.d(ACTIVITY_TAG, "This is not the first time executed");

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
            // In single-pane mode, simply start the detail activity for the selected item ID.
            Intent detailIntent = new Intent(this, SensorDetailActivity.class);
            detailIntent.putExtra(SensorDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    //http://developer.android.com/reference/android/os/AsyncTask.html
    private class SetupDatabase extends AsyncTask <Activity, Integer, SQLiteDatabase>{
        @Override
        protected SQLiteDatabase doInBackground(Activity... params) {
            Log.d(SensorListActivity.ACTIVITY_TAG, "Initializing Database Installation");
            DBHelper helper = new DBHelper(params[0]);
            SQLiteDatabase db = helper.getWritableDatabase();
            return db;
        }
        protected void onPostExecute(SQLiteDatabase db) {
           Log.d(SensorListActivity.ACTIVITY_TAG, "Database Install Completed");
        }
    }
}
