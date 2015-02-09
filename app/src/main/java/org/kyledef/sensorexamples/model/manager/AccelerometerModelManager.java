package org.kyledef.sensorexamples.model.manager;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import org.kyledef.sensorexamples.model.AccelerometerModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class AccelerometerModelManager extends SensorModelManager {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + AccelerometerEntry.TABLE_NAME + " (" +
            AccelerometerEntry._ID + INT_TYPE + " PRIMARY KEY, " +
            AccelerometerEntry.AXIS_X + REAL_TYPE + COMMA_SEP +
            AccelerometerEntry.AXIS_Y + REAL_TYPE + COMMA_SEP +
            AccelerometerEntry.AXIS_Z + REAL_TYPE + COMMA_SEP +
            AccelerometerEntry.TIME_TAKEN + TIMESTAMP + ") ;";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + AccelerometerEntry.TABLE_NAME;

    public AccelerometerModelManager(SQLiteDatabase db) { super(db);  }

    @Override
    public boolean saveEntry(float[] values) {
        ContentValues cv = new ContentValues();
        cv.put(AccelerometerEntry.AXIS_X, values[0]);
        cv.put(AccelerometerEntry.AXIS_Y, values[1]);
        cv.put(AccelerometerEntry.AXIS_Z, values[2]);
        cv.put(AccelerometerEntry.TIME_TAKEN, dFormat.format(new Date()));

        long res = this.db.insert(AccelerometerEntry.TABLE_NAME, null, cv);
        return (res != -1);
    }

    @Override
    public List <AccelerometerModel> retrieveEntry(Date start, Date end) {
        ArrayList <AccelerometerModel> list = new ArrayList<AccelerometerModel>();

        String startStr = dFormat.format(start),
                endStr = dFormat.format(end);

        StringBuilder stb = new StringBuilder();
        stb.append("SELECT * FROM ")
            .append(AccelerometerEntry.TABLE_NAME)
            .append(" WHERE ").append(AccelerometerEntry.TIME_TAKEN)
            .append(" BETWEEN ")
            .append(startStr)
            .append(" AND ")
            .append(endStr);

        Cursor res = db.rawQuery(stb.toString(), null);
        while(res.moveToNext()){
            AccelerometerModel ac = new AccelerometerModel();
            ac.setAxisX(res.getFloat(res.getColumnIndex(AccelerometerEntry.AXIS_X)));
            ac.setAxisY(res.getFloat(res.getColumnIndex(AccelerometerEntry.AXIS_Y)));
            ac.setAxisZ(res.getFloat(res.getColumnIndex(AccelerometerEntry.AXIS_Z)));
            ac.setTimeTaken(res.getString(res.getColumnIndex(AccelerometerEntry.TIME_TAKEN)));
            list.add(ac);
        }
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
