package org.kyledef.sensorexamples.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.Date;
import java.util.List;


public class LightModel extends SensorModel {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + LightEntry.TABLE_NAME + " (" +
                    LightEntry._ID + INT_TYPE + " PRIMARY KEY, " +
                    LightEntry.LUX + REAL_TYPE + COMMA_SEP +
                    LightEntry.TIME_TAKEN + TIMESTAMP + ") ;";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + LightEntry.TABLE_NAME;

    public static abstract class LightEntry implements BaseColumns {
        public static final String TABLE_NAME = "light";
        public static final String LUX = "lux";
        public static final String TIME_TAKEN = "time_taken";
    }

    public LightModel(SQLiteDatabase db) { super(db);  }

    @Override
    public boolean saveEntry(double[] values) {
        return false;
    }

    @Override
    public List retrieveEntry(Date start, Date end) {
        return null;
    }

    @Override
    public boolean deleteEntry(int id) {
        return false;
    }


}