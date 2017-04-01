package com.example.android.order;

/**
 * Created by sibby on 3/31/2017.
 */

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Page22 extends ListActivity {
    ArrayList<HashMap<String, String>> inboxList;
    String[] stocks;
    String[] price;
    int i;
    String s;
    String p;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twotwo);
        inboxList = new ArrayList<HashMap<String, String>>();
        stocks = getResources().getStringArray(R.array.stock);
        price = getResources().getStringArray(R.array.prices);
        try {
            for (i = 0; i < 17; i++) {
                s = stocks[i+67];
                p = price[i+67];
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("product", s);
                map.put("price", p);
                inboxList.add(map);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                Page22.this,inboxList,
                R.layout.list_item, new String[] {"product", "price" },
                new int[] { R.id.product, R.id.price });
        // updating listview
        setListAdapter(adapter);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Globals g = Globals.getInstance();
                int data = g.getData();
                data += Integer.parseInt(price[position + 67]);
                g.setData(data);
                Toast.makeText(getApplicationContext(),stocks[position+67]+" added to cart",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Total price is "+data,Toast.LENGTH_SHORT).show();
            }
        });
    }
}