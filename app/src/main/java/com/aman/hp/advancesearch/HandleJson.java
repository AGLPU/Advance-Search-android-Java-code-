package com.aman.hp.advancesearch;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HP on 17-06-2015.
 */
public class HandleJson {

    String JSonData;

/*
    LinkedHashSet<LinkedHashSet<String>> hashSet=new LinkedHashSet<LinkedHashSet<String>>();

    LinkedHashSet<String> latitudeSet=new LinkedHashSet<String>();
    LinkedHashSet<String> longitudeSet=new LinkedHashSet<String>();
    LinkedHashSet<String> descriptionSet=new LinkedHashSet<String>();
    LinkedHashSet<String> gpsTimeSet=new LinkedHashSet<String>();
    LinkedHashSet<String> PlateNumberSet=new LinkedHashSet<String>();
    LinkedHashSet<String> SSNSet=new LinkedHashSet<String>();

    LinkedHashSet<String> ObjectIdSet=new LinkedHashSet<String>();
    LinkedHashSet<String> lastStateSet=new LinkedHashSet<String>();
    LinkedHashSet<String> alertSet=new LinkedHashSet<String>();
    LinkedHashSet<String> speedSet=new LinkedHashSet<String>();
*/



    ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();

    ArrayList<String> latitudeSet=new ArrayList<String>();
    ArrayList<String> longitudeSet=new ArrayList<String>();
    ArrayList<String> descriptionSet=new ArrayList<String>();
    ArrayList<String> gpsTimeSet=new ArrayList<String>();
    ArrayList<String> PlateNumberSet=new ArrayList<String>();
    ArrayList<String> SSNSet=new ArrayList<String>();

    ArrayList<String> ObjectIdSet=new ArrayList<String>();
    ArrayList<String> lastStateSet=new ArrayList<String>();
    ArrayList<String> alertSet=new ArrayList<String>();
    ArrayList<String> speedSet=new ArrayList<String>();



    public HandleJson(){

}

    public ArrayList<ArrayList<String>> readAndParse(String data){

        try {

            JSONArray jsonArray = new JSONArray(data);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                latitudeSet.add(jsonObject.getString(Constants.TAG_LATITUDE));
                longitudeSet.add(jsonObject.getString(Constants.TAG_LONGITUDE));
                PlateNumberSet.add(jsonObject.getString(Constants.TAG_PLATENUMBER));
                SSNSet.add(jsonObject.getString(Constants.TAG_SOCIALNUMBER));
                descriptionSet.add(jsonObject.getString(Constants.TAG_DESCRIPTION));
                gpsTimeSet.add(jsonObject.getString(Constants.TAG_GPSTIME));

                speedSet.add(jsonObject.getString(Constants.TAG_SPEED));
                ObjectIdSet.add(jsonObject.getString(Constants.TAG_OBJECTID));
                lastStateSet.add(jsonObject.getString(Constants.TAG_LASTSTATE));
                alertSet.add(jsonObject.getString(Constants.TAG_ALERT));

            }
            list.add(latitudeSet);
            list.add(longitudeSet);
            list.add(PlateNumberSet);
            list.add(SSNSet);
            list.add(descriptionSet);
            list.add(gpsTimeSet);
            list.add(speedSet);
            list.add(ObjectIdSet);
            list.add(lastStateSet);
            list.add(alertSet);
       }

        catch(Exception e)
        {
e.printStackTrace();

}
        return list;
}
}
