package org.kyledef.sensorexamples.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.kyledef.sensorexamples.model.manager.AccelerometerModelManager;
import org.kyledef.sensorexamples.model.manager.GravityModelManager;
import org.kyledef.sensorexamples.model.manager.GyroscopeModelManager;
import org.kyledef.sensorexamples.model.manager.LightModelManager;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "sensors.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AccelerometerModelManager.CREATE_TABLE);
        db.execSQL(GravityModelManager.CREATE_TABLE);
        db.execSQL(GyroscopeModelManager.CREATE_TABLE);
        db.execSQL(LightModelManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Handle Update Logic
        //Modify tables, add data etc
    }
}
