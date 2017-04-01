package com.example.android.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class newPurchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_purchase);
        TextView textview1 = (TextView)findViewById(R.id.textview1);
        TextView textview2 = (TextView)findViewById(R.id.textview2);
        Globals g = Globals.getInstance();
        g.setData(0);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(newPurchase.this, confirmPurchase.class);
                startActivity(intent);
            }});
        textview1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(newPurchase.this, catOne.class);
                startActivity(intent);
            }
        });
        textview2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(newPurchase.this, catTwo.class);
                startActivity(intent);
            }
        });
    }
}
