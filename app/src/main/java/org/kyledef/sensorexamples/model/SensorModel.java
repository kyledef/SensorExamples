package org.kyledef.sensorexamples.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SensorModel {
    float axisX;
    float axisY;
    float axisZ;
    Date timeTaken;

    protected final SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public float getAxisX() {
        return axisX;
    }

    public void setAxisX(float axisX) { this.axisX = axisX; }

    public float getAxisY() {
        return axisY;
    }

    public void setAxisY(float axisY) {
        this.axisY = axisY;
    }

    public float getAxisZ() {
        return axisZ;
    }

    public void setAxisZ(float axisZ) {
        this.axisZ = axisZ;
    }

    public Date getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Date timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setTimeTaken(String timeTaken){
        try {
            this.timeTaken = (Date)this.dFormat.parse(timeTaken);
        } catch (ParseException e) { e.printStackTrace();}
    }
}
