package com.example.android.order;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class catOne extends TabActivity {
    private static final String ONEONE = "Page1";
    private static final String ONETWO = "Page2";
    private static final String ONETHREE = "Page3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_one);
        TabHost tabHost = getTabHost();

        // Inbox Tab
        TabHost.TabSpec oneone = tabHost.newTabSpec(ONEONE);
        oneone.setIndicator(ONEONE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent = new Intent(this, Page1.class);
        // Tab Content
        oneone.setContent(inboxIntent);

        // Outbox Tab
        TabHost.TabSpec onetwo = tabHost.newTabSpec(ONETWO);
        onetwo.setIndicator(ONETWO, getResources().getDrawable(R.drawable.icon_inbox));
        Intent outboxIntent = new Intent(this, Page2.class);
        onetwo.setContent(outboxIntent);

        // Profile Tab
        TabHost.TabSpec onethree = tabHost.newTabSpec(ONETHREE);
        onethree.setIndicator(ONETHREE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent profileIntent = new Intent(this, Page3.class);
        onethree.setContent(profileIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(oneone); // Adding Inbox tab
        tabHost.addTab(onetwo); // Adding Outbox tab
        tabHost.addTab(onethree); // Adding Profile tab
    }
}
