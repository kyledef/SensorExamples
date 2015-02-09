package org.kyledef.sensorexamples.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.Date;
import java.util.List;

public class GyroscopeModel extends SensorModel {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + GyroscopeEntry.TABLE_NAME + " (" +
                    GyroscopeEntry._ID + INT_TYPE + " PRIMARY KEY, " +
                    GyroscopeEntry.AXIS_X + REAL_TYPE + COMMA_SEP +
                    GyroscopeEntry.AXIS_Y + REAL_TYPE + COMMA_SEP +
                    GyroscopeEntry.AXIS_Z + REAL_TYPE + COMMA_SEP +
                    GyroscopeEntry.TIME_TAKEN + TIMESTAMP + ") ;";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + GyroscopeEntry.TABLE_NAME;

    public static abstract class GyroscopeEntry implements BaseColumns {
        public static final String TABLE_NAME = "gyroscope";
        public static final String AXIS_X = "xaxis";
        public static final String AXIS_Y = "yaxis";
        public static final String AXIS_Z = "zaxis";
        public static final String TIME_TAKEN = "time_taken";
    }

    public GyroscopeModel(SQLiteDatabase db) { super(db);  }

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