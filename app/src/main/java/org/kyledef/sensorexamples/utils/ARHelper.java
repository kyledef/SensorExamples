package org.kyledef.sensorexamples.utils;


import android.content.Context;

import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;

import org.kyledef.sensorexamples.R;

public class ARHelper {

    public static World createDefaultWorld(Context context){
        World world = new World(context);
        world.setDefaultImage(R.drawable.flag);
        world.setGeoPosition(41.90533734214473d, 2.565848038959814d);

        GeoObject go1 = new GeoObject(1l);
        go1.setGeoPosition(41.90523339794433d, 2.565036406654116d);
        go1.setImageResource(R.drawable.flag);
        go1.setName("Flag 1");

        GeoObject go2 = new GeoObject(2l);
        go2.setGeoPosition(41.90518966360719d, 2.56582424468222d);
        go2.setImageResource(R.drawable.flag);
        go2.setName("Flag 2");

        world.addBeyondarObject(go1);
        world.addBeyondarObject(go2);

        return world;
    }
}
