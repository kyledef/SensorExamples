package org.kyledef.sensorexamples.model.manager;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.Date;
import java.util.List;


public class GravityModelManager extends SensorModelManager {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + GravityEntry.TABLE_NAME + " (" +
                    GravityEntry._ID + INT_TYPE + " PRIMARY KEY, " +
                    GravityEntry.AXIS_X + REAL_TYPE + COMMA_SEP +
                    GravityEntry.AXIS_Y + REAL_TYPE + COMMA_SEP +
                    GravityEntry.AXIS_Z + REAL_TYPE + COMMA_SEP +
                    GravityEntry.TIME_TAKEN + TIMESTAMP + ") ;";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + GravityEntry.TABLE_NAME;

    public static abstract class GravityEntry implements BaseColumns {
        public static final String TABLE_NAME = "gravity";
        public static final String AXIS_X = "xaxis";
        public static final String AXIS_Y = "yaxis";
        public static final String AXIS_Z = "zaxis";
        public static final String TIME_TAKEN = "time_taken";
    }

    public GravityModelManager(SQLiteDatabase db) { super(db);  }

    @Override
    public boolean saveEntry(float[] values) {
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