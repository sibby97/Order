package com.example.android.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class myPurchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_purchase);
        TextView textView = (TextView) findViewById(R.id.textView);
        int i;
        String[] ps = new String[50];
        String total = " ";
        Globals g = Globals.getInstance();
        for(i = 0;i<g.getConfcount();i++){
            ps[i] = Integer.toString(g.getConfdata(i));
            total += "You have purchased "+ps[i]+"\n";
        }
        textView.setText(total);
    }
}
