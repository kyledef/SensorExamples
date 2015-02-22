package org.kyledef.sensorexamples.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.kyledef.sensorexamples.BaseActivity;
import org.kyledef.sensorexamples.R;

public class MainMenu extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MainMenuFragment())
                .commit();

        this.setUpNavDrawer();
    }

    public void overView(View v){
        Toast.makeText(this, "Selected Overview", Toast.LENGTH_SHORT).show();
    }

    public void sensors(View v){
        Toast.makeText(this, "Selected Sensors", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainMenu.class));
    }

    public void augReality(View v){
        Toast.makeText(this, "Selected Augmented Reality", Toast.LENGTH_SHORT).show();
    }

    public void activity(View v){
        Toast.makeText(this, "Selected Activity", Toast.LENGTH_SHORT).show();
    }

    public void contextComp(View v){
        Toast.makeText(this, "Selected Contextual Computing", Toast.LENGTH_SHORT).show();
    }




}
