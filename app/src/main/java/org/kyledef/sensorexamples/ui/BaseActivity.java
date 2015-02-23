package org.kyledef.sensorexamples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.Toast;

import org.kyledef.sensorexamples.R;

/**
 * Created by kyle on 2/22/15.
 */
public class BaseActivity extends ActionBarActivity  implements NavigationDrawerFragment.NavigationDrawerCallbacks{

    protected NavigationDrawerFragment mNavigationDrawerFragment;
    protected CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void setUpNavDrawer(){
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        // Set up the drawer.
        mNavigationDrawerFragment.setUp( R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Intent i = null;
        switch (position){
            case 0:
                i = new Intent(this, MainMenu.class);;
                break;
            case 1:
                i = new Intent(this, SensorListActivity.class);
                break;
            case 2:
                i = new Intent(this, AugmentedRealityMain.class);
                break;
            case 3:
                Toast.makeText(this, "Activity Recognition not yet available", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Contextual Computing not yet available", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Action not found", Toast.LENGTH_SHORT).show();
                i = new Intent(this, MainMenu.class); // Send User back to home screen
                break;
        }
        if (i != null){
            startActivity(i);
            finish();
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mNavigationDrawerFragment == null || !mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }
}
