package org.kyledef.sensorexamples.model.manager;

import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class SensorModelManager {
    protected static final String TEXT_TYPE = " TEXT";
    protected static final String COMMA_SEP = " , ";
    protected static final String INT_TYPE = " INTEGER";
    protected static final String REAL_TYPE = " REAL";
    protected static final String TIMESTAMP = " DATETIME DEFAULT CURRENT_TIMESTAMP";

    protected SQLiteDatabase db;
    protected final SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public SensorModelManager(SQLiteDatabase db){
        this.db = db;
    }

    /**
     * Save a reading entry from the sensor
     * @param values The array of values extracted from the sensor
     * @return true if stored successfully and false otherwise
     */
    public abstract boolean saveEntry(float[] values);

    /**
     * This method will retrieve all of the values between dates specified
     * @param start Start date of the query of records
     * @param end End date of the query of records
     * @return The list of all the values/reading retrieved
     */
    public abstract List retrieveEntry(Date start, Date end);

    /**
     * Deletes an entry based on the id supplied
     * @param id the primary key of the reading
     * @return true if operation successful and false otherwise
     */
    public abstract boolean deleteEntry(int id);
}
