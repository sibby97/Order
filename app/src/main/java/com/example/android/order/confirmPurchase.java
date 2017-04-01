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
        String input = "Your total Purchase costs"+g.getData();
        conftext.setText(input);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Globals g = Globals.getInstance();
                g.setConfcount();
                g.setConfData(g.getData(),g.getConfcount());
                Intent intent = new Intent(confirmPurchase.this, MainActivity.class);
                startActivity(intent);
            }});
    }
}
