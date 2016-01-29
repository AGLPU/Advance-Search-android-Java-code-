package com.aman.hp.advancesearch;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HP on 17-06-2015.
 */
public class Constants {

    public static String TAG_LATITUDE="latitude";
    public static String TAG_LONGITUDE="longitude";
    public static String TAG_PLATENUMBER="PlateNumber";
    public static String TAG_SOCIALNUMBER="SocialNumber";
    public static String TAG_GPSTIME="GpsTime";
    public static String TAG_DESCRIPTION="Description";

    public static String TAG_LASTSTATE="laststate";
    public static String TAG_ALERT="alert";
    public static String TAG_OBJECTID="objectId";
    public static String TAG_SPEED="speed";

    public static String TAG_LASTFUELTIME="lastfueltime";
    public static String TAG_LASTFUELVALUE="lastfuelvalue";



    public static String APPLICATION_SETTING_PREFRENCES="APPLICATION_1";

    public static String TAG_USERNAME="username";
    public static String TAG_PASSWORD="password";
    public static String TAG_INSTANCE="instance";
    public static String TAG_SERVER="server";


   public static SharedPreferences sharedPrefs;
   public static String userName,password,instanceName,serverName;

    public static String Vehicle_List_Url(Context context,String plateNumberStr){
        sharedPrefs=context.getSharedPreferences(Constants.APPLICATION_SETTING_PREFRENCES, context.MODE_APPEND);
        userName=sharedPrefs.getString(Constants.TAG_USERNAME,"").toString();
        password=sharedPrefs.getString(Constants.TAG_PASSWORD,"").toString();
        instanceName=sharedPrefs.getString(Constants.TAG_INSTANCE,"").toString();

        serverName=sharedPrefs.getString(Constants.TAG_SERVER,"").toString();
       return "http://"+serverName+"/"+instanceName+"/api/homeVehicleDetails?username="+userName+"&password="+password+"&platenumber=" + plateNumberStr;


    }

}
