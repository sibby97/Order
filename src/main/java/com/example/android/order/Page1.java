package com.example.android.order;

/**
 * Created by sibby on 3/31/2017.
 */

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Page1 extends ListActivity {
    ArrayList<HashMap<String, String>> inboxList;
    String[] stocks;
    String[] price;
    int i;
    String s,p;
    private PAdapter padapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oneone_list);
        inboxList = new ArrayList<HashMap<String, String>>();
        stocks = getResources().getStringArray(R.array.stock);
        price = getResources().getStringArray(R.array.prices);
        try {
            for (i = 0; i < 17; i++) {
                s = stocks[i];
                p = price[i];
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("product", s);
                map.put("price", p);
                map.put("value","0");
                inboxList.add(map);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        PAdapter adapter = new PAdapter(
                Page1.this,inboxList,
                R.layout.list_item, new String[] {"product", "price", "value"},
                new int[] { R.id.product, R.id.price ,R.id.val});
        // updating listview
        setListAdapter(adapter);
        Button inc = (Button) findViewById(R.id.increment);
        Button dec = (Button) findViewById(R.id.decrement);
        final TextView val = (TextView) findViewById(R.id.val);
        ListView listView = (ListView) findViewById(android.R.id.list);
        /*inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = getListView().getPositionForView(v);
                if(position != ListView.INVALID_POSITION){
                    Globals g = Globals.getInstance();
                    g.incValue(position);
                    val.setText(Integer.toString(g.getValue(position)));
                }
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = getListView().getPositionForView(v);
                if(position != ListView.INVALID_POSITION){
                    Globals g = Globals.getInstance();
                    g.decValue(position);
                    val.setText(Integer.toString(g.getValue(position)));
                }
            }
        });*/
    }

    static class ViewHolder{
        private TextView product;
        private TextView price;
        private TextView val;
    }

    private class Elements{
        public String stk;
        public String prc;
        public Elements(String p, String s){
            this.stk = s;
            this.prc = p;
        }
    }

    private class PAdapter extends SimpleAdapter {
        public PAdapter(Context context, ArrayList<HashMap<String, String>> arrayList,
                        int layout, String[] strings,
                        int[] ints){
            super(context,arrayList,layout,strings,ints);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null) {
                Globals g = Globals.getInstance();
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);

                holder = new ViewHolder();
                holder.product = (TextView) convertView.findViewById(R.id.product);
                holder.price = (TextView) convertView.findViewById(R.id.price);
                holder.val = (TextView) convertView.findViewById(R.id.val);
                final View finalConvertView = convertView;
                ((Button) convertView.findViewById(R.id.increment)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final int position = getListView().getPositionForView(v);
                        if (position != ListView.INVALID_POSITION) {
                            Globals g = Globals.getInstance();
                            g.incValue(position);
                            TextView x = (TextView) finalConvertView.findViewById(R.id.val);
                            x.setText(Integer.toString(g.getValue(position)));
                        }
                    }
                });
                ((Button) convertView.findViewById(R.id.decrement)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final int position = getListView().getPositionForView(v);
                        if (position != ListView.INVALID_POSITION) {
                            Globals g = Globals.getInstance();
                            g.decValue(position);
                            TextView x = (TextView) finalConvertView.findViewById(R.id.val);
                            x.setText(Integer.toString(g.getValue(position)));
                        }
                    }
                });
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Globals g = Globals.getInstance();
            stocks = getResources().getStringArray(R.array.stock);
            price = getResources().getStringArray(R.array.prices);
            holder.product.setText(stocks[position]);
            holder.price.setText(price[position]);
            holder.val.setText(Integer.toString(g.getValue(position)));

            return convertView;
        }
    }
}