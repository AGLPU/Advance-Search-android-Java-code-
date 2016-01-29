package com.aman.hp.advancesearch;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.advancesearch.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HP on 18-06-2015.
 */
public class VehicleListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context ctx;
    ArrayList<ArrayList<String>> vList = new ArrayList<ArrayList<String>>();
    ArrayList<String> plateNumberList = new ArrayList<String>();
    ArrayList<String> alertList = new ArrayList<String>();
    ArrayList<String> lastStatList = new ArrayList<String>();
    ArrayList<String> SSNList = new ArrayList<String>();

    ArrayList<String> latitudeList = new ArrayList<String>();
    ArrayList<String> longitudeList = new ArrayList<String>();

    ArrayList<String> allData = new ArrayList<String>();
    ArrayList<String> allDataLatitudeList = new ArrayList<String>();
    ArrayList<String> allDataLongitudeList = new ArrayList<String>();
    ArrayList<String> allSpeedList = new ArrayList<String>();
    ArrayList<String> allSSNList = new ArrayList<String>();
    ArrayList<String> allDataStatList = new ArrayList<String>();

    ArrayList<String> speedList = new ArrayList<String>();
    HandleJson handle = new HandleJson();

    ArrayList<ModelClass>objectList=new ArrayList<ModelClass>();
    String JsonData;
    SharedPreferences sharedPrefs;
    String userName,password,instanceName;


    // public VehicleListAdapter(Context context,ArrayList<ArrayList<String>> vList){
    public VehicleListAdapter(Context context, String Jsondata) {

        this.ctx = context;
        this.inflater = (LayoutInflater) ctx.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        JsonData = Jsondata;

        vList = handle.readAndParse(JsonData);

        plateNumberList = vList.get(2);

        SSNList = vList.get(3);
        latitudeList = vList.get(0);
        longitudeList = vList.get(1);
        lastStatList = vList.get(8);
        alertList = vList.get(9);

        speedList = vList.get(6);

       /* SSNList.add(3,"NS02312");
        SSNList.add(4,"NS12223");*/


        allData.addAll(plateNumberList);
        allDataLatitudeList.addAll(latitudeList);
        allDataLongitudeList.addAll(longitudeList);
        allSpeedList.addAll(speedList);
        allSSNList.addAll(SSNList);
        allDataStatList.addAll(lastStatList);


    }

    @Override
    public int getCount() {

        return plateNumberList.size();
    }

    @Override
    public Object getItem(int position) {

        return plateNumberList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null)

            convertView = inflater.inflate(R.layout.vehicle_listview_layout, null);

        final TextView plateNumberVw = (TextView) convertView.findViewById(R.id.textView1);
        final TextView SSNVw = (TextView) convertView.findViewById(R.id.textView3);



       /* plateNumberVw.setText(objectList.get(position).getPlateNumber());

        SSNVw.setText(objectList.get(position).getSSNNumber());
*/

        plateNumberVw.setText(plateNumberList.get(position).toString());

        SSNVw.setText(SSNList.get(position).toString());

        return convertView;
    }

    public void filter(String str) {

        plateNumberList.clear();
        latitudeList.clear();
        longitudeList.clear();
        lastStatList.clear();
        speedList.clear();
        SSNList.clear();
        if (str.length() == 0) {
            plateNumberList.addAll(allData);
            latitudeList.addAll(allDataLatitudeList);
            longitudeList.addAll(allDataLongitudeList);
            speedList.addAll(allSpeedList);
            SSNList.addAll(allSSNList);
            lastStatList.addAll(allDataStatList);

        }
        else {
            for(int i=0;i<allData.size();i++){
                if(allData.get(i).contains(str.toUpperCase())){
                    plateNumberList.add(allData.get(i));
                    speedList.add(allSpeedList.get(i));

                    SSNList.add(allSSNList.get(i));
                    latitudeList.add(allDataLatitudeList.get(i));
                    longitudeList.add(allDataLongitudeList.get(i));
                    lastStatList.add(allDataStatList.get(i));
                }
                else if(allSSNList.get(i).contains(str.toUpperCase())){

                    plateNumberList.add(allData.get(i));
                    speedList.add(allSpeedList.get(i));
                    SSNList.add(allSSNList.get(i));
                    latitudeList.add(allDataLatitudeList.get(i));
                    longitudeList.add(allDataLongitudeList.get(i));
                    lastStatList.add(allDataStatList.get(i));
                }
            }



        }
        notifyDataSetChanged();
    }



    public void sortAsc(){
        Collections.sort(plateNumberList);
        speedList.clear();
        SSNList.clear();
        latitudeList.clear();
        longitudeList.clear();
        lastStatList.clear();
        for(int i=0;i<plateNumberList.size();i++){
          // Log.e("INDEXX", String.valueOf(allData.indexOf(plateNumberList.get(i).toString())));

            latitudeList.add(i, allDataLatitudeList.get(allData.indexOf(plateNumberList.get(i).toString())));
            longitudeList.add(i, allDataLongitudeList.get(allData.indexOf(plateNumberList.get(i).toString())));
            lastStatList.add(i, allDataStatList.get(allData.indexOf(plateNumberList.get(i).toString())));
            speedList.add(i, allSpeedList.get(allData.indexOf(plateNumberList.get(i).toString())));
            SSNList.add(i,allSSNList.get(allData.indexOf(plateNumberList.get(i).toString())));
        }
        notifyDataSetChanged();
    }



}