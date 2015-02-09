package org.kyledef.sensorexamples.model.manager;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.Date;
import java.util.List;

public class RotationModelManager extends SensorModelManager {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + RotationEntry.TABLE_NAME + " (" +
                    RotationEntry._ID + INT_TYPE + " PRIMARY KEY, " +
                    RotationEntry.AXIS_X + REAL_TYPE + COMMA_SEP +
                    RotationEntry.AXIS_Y + REAL_TYPE + COMMA_SEP +
                    RotationEntry.AXIS_Z + REAL_TYPE + COMMA_SEP +
                    RotationEntry.TIME_TAKEN + TIMESTAMP + ") ;";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + RotationEntry.TABLE_NAME;

    public static abstract class RotationEntry implements BaseColumns {
        public static final String TABLE_NAME = "rotation";
        public static final String AXIS_X = "xaxis";
        public static final String AXIS_Y = "yaxis";
        public static final String AXIS_Z = "zaxis";
        public static final String TIME_TAKEN = "time_taken";
    }

    public RotationModelManager(SQLiteDatabase db) { super(db);  }

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