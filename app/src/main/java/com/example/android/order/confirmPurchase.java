package com.example.android.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmPurchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_purchase);
        TextView conftext = (TextView) findViewById(R.id.conftext);
        Globals g = Globals.getInstance();
        String[] price = getResources().getStringArray(R.array.prices);
        String[] stock = getResources().getStringArray(R.array.stock);
        String input = "Your total Purchase costs: ";
        int x = 0 ,total = 0;
        for(int i =0;i<100;i++){
            if(g.getValue(i)>0) {
                x = g.getValue(i) * Integer.parseInt(price[i]);
                input += "\n" + " for the product " + stock[i] + " = " + x;
                total += x;
            }
        }
        input += "\n" + " Your total purchase is = "+total;
        conftext.setText(input);
        Button button2 = (Button) findViewById(R.id.button2);
        final int finalTotal = total;
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                g.setConfcount();
                g.setConfData(finalTotal,g.getConfcount());
                Intent intent = new Intent(confirmPurchase.this, MainActivity.class);
                startActivity(intent);
            }});
    }
}
