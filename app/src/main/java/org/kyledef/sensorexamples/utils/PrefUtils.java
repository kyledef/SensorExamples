package org.kyledef.sensorexamples.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefUtils {

    private static final String FIRST_USE = "first_use";

    public static boolean isFirstUse(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(FIRST_USE, true);
    }

    public static void setFirstUse(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(FIRST_USE, false).commit();
    }
}
