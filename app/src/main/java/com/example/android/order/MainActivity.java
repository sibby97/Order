package com.example.android.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview1 = (TextView)findViewById(R.id.textview1);
        TextView textview2 = (TextView)findViewById(R.id.textview2);
        textview1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, newPurchase.class);
                startActivity(intent);
            }
        });
        textview2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, myPurchase.class);
                startActivity(intent);
            }
        });
    }
}
