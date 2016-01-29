package com.aman.hp.advancesearch;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hp.advancesearch.R;

import java.util.ArrayList;

public class MainActivity extends Activity {


    String jsonData="[{\"latitude\":41.4634588,\"longitude\":12.8449133,\"PlateNumber\":\"EL369DD12\",\"SocialNumber\":\"GOEL12\",\"GpsTime\":\"2016-01-29T06:11:00Z\",\"Description\":\"LANCIA \n" +
            "Y\",\"laststate\":0,\"alert\":0,\"objectId\":639,\"speed\":0},{\"latitude\":41.449844,\"longitude\":12.9475548,\"PlateNumber\":\"EG316ZD11\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-\n" +
            "29T04:14:33Z\",\"Description\":\"OPEL VIVARO\",\"laststate\":0,\"alert\":0,\"objectId\":640,\"speed\":0},\n" +
            "{\"latitude\":41.5068333,\"longitude\":12.8928843,\"PlateNumber\":\"EN075K2S\",\"SocialNumber\":\"ANDROID\",\"GpsTime\":\"2016-01-29T06:23:28Z\",\"Description\":\"OPEL \n" +
            "VIVARO\",\"laststate\":0,\"alert\":0,\"objectId\":638,\"speed\":0},{\"latitude\":41.4838636,\"longitude\":12.9156361,\"PlateNumber\":\"EJ30t4ZD\",\"SocialNumber\":null,\"GpsTime\":\"2016-\n" +
            "01-29T06:11:22Z\",\"Description\":\"OPEL VIVARO\",\"laststate\":1,\"alert\":0,\"objectId\":637,\"speed\":0},\n" +
            "{\"latitude\":41.4733596,\"longitude\":13.0034728,\"PlateNumber\":\"EJ3238ZD\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-28T23:16:04Z\",\"Description\":\"OPEL \n" +
            "VIVARO\",\"laststate\":0,\"alert\":2,\"objectId\":636,\"speed\":0},{\"latitude\":41.4848256,\"longitude\":12.9168256,\"PlateNumber\":\"EJ3t54ZD\",\"SocialNumber\":null,\"GpsTime\":\"2016-\n" +
            "01-29T06:32:20Z\",\"Description\":\"OPEL VIVARO\",\"laststate\":1,\"alert\":0,\"objectId\":642,\"speed\":6},\n" +
            "{\"latitude\":41.5145946,\"longitude\":12.8521016,\"PlateNumber\":\"EL5147DD\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-29T04:06:01Z\",\"Description\":\"RENAULT \n" +
            "MEGANE\",\"laststate\":0,\"alert\":0,\"objectId\":645,\"speed\":0},{\"latitude\":41.483065,\"longitude\":12.8657956,\"PlateNumber\":\"EP5t51WP\",\"SocialNumber\":null,\"GpsTime\":\"2016-01\n" +
            "-29T06:17:05Z\",\"Description\":\"FIAT PANDA\",\"laststate\":0,\"alert\":0,\"objectId\":646,\"speed\":0},\n" +
            "{\"latitude\":45.3995796,\"longitude\":8.9332571,\"PlateNumber\":\"EJ9465ZD\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-29T06:33:25Z\",\"Description\":\"GOLF \n" +
            "TDI\",\"laststate\":0,\"alert\":0,\"objectId\":652,\"speed\":0},{\"latitude\":41.6445186,\"longitude\":12.9074776,\"PlateNumber\":\"ED0t92JF\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-\n" +
            "29T04:56:35Z\",\"Description\":\"FIAT PUNTO EVO\",\"laststate\":0,\"alert\":0,\"objectId\":659,\"speed\":0},\n" +
            "{\"latitude\":41.3945148,\"longitude\":13.0905683,\"PlateNumber\":\"ED09r6JF\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-29T06:35:03Z\",\"Description\":\"FIAT PUNTO \n" +
            "EVO\",\"laststate\":1,\"alert\":0,\"objectId\":660,\"speed\":81},{\"latitude\":41.4766583,\"longitude\":12.9078113,\"PlateNumber\":\"EKt863GY\",\"SocialNumber\":null,\"GpsTime\":\"2016-01-\n" +
            "29T06:08:34Z\",\"Description\":\"OPEL MERIVA\",\"laststate\":0,\"alert\":0,\"objectId\":676,\"speed\":0}]";

    ListView listView1;
    ArrayList<ArrayList<String>> vList=new ArrayList<ArrayList<String>>();

    EditText searchEditTextVw;
    Button sortBtnVw;
    ArrayList<String> plateNumberList=new ArrayList<String>();



    VehicleListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView1= (ListView) findViewById(R.id.listView1);
        // listView1.setHeaderImage(BitmapFactory.decodeResource(getResources(), R.drawable.header_image1));

        adapter=new VehicleListAdapter(getApplicationContext(),jsonData);
        listView1.setAdapter(adapter);
        searchEditTextVw=(EditText)findViewById(R.id.searchEditTextView);
        adapter.sortAsc();

        searchEditTextVw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
