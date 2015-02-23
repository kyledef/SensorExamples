package org.kyledef.sensorexamples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        startActivity(new Intent(this, SensorListActivity.class));
    }

    public void augReality(View v){
        Toast.makeText(this, "Selected Augmented Reality", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, AugmentedRealityMain.class));
    }

    public void activity(View v){
        Toast.makeText(this, "Selected Activity", Toast.LENGTH_SHORT).show();
    }

    public void contextComp(View v){
        Toast.makeText(this, "Selected Contextual Computing", Toast.LENGTH_SHORT).show();
    }




}
