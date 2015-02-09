package org.kyledef.sensorexamples.model;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class AccelerometerModel extends SensorModel {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + AccelerometerEntry.TABLE_NAME + " (" +
            AccelerometerEntry._ID + INT_TYPE + " PRIMARY KEY, " +
            AccelerometerEntry.AXIS_X + REAL_TYPE + COMMA_SEP +
            AccelerometerEntry.AXIS_Y + REAL_TYPE + COMMA_SEP +
            AccelerometerEntry.AXIS_Z + REAL_TYPE + COMMA_SEP +
            AccelerometerEntry.TIME_TAKEN + TIMESTAMP + ") ;";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + AccelerometerEntry.TABLE_NAME;

    public AccelerometerModel(SQLiteDatabase db) { super(db);  }

    @Override
    public boolean saveEntry(double[] values) {
        ContentValues cv = new ContentValues();
        cv.put(AccelerometerEntry.AXIS_X, values[0]);
        cv.put(AccelerometerEntry.AXIS_Y, values[1]);
        cv.put(AccelerometerEntry.AXIS_Z, values[2]);
        cv.put(AccelerometerEntry.TIME_TAKEN, dFormat.format(new Date()));

        long res = this.db.insert(AccelerometerEntry.TABLE_NAME, null, cv);
        return (res != -1);
    }

    @Override
    public List retrieveEntry(Date start, Date end) {

        String startStr = dFormat.format(start),
                endStr = dFormat.format(end);

        return null;
    }

    @Override
    public boolean deleteEntry(int id) {
        return false;
    }

    public static abstract class AccelerometerEntry implements BaseColumns {
        public static final String TABLE_NAME = "accelerometer";
        public static final String AXIS_X = "xaxis";
        public static final String AXIS_Y = "yaxis";
        public static final String AXIS_Z = "zaxis";
        public static final String TIME_TAKEN = "time_taken";
    }

}
