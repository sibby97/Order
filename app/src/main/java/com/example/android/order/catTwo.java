package com.example.android.order;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class catTwo extends TabActivity {
    private static final String TWOONE = "Page1";
    private static final String TWOTWO = "Page2";
    private static final String TWOTHREE = "Page3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_two);
        TabHost tabHost = getTabHost();

        // Inbox Tab
        TabHost.TabSpec twoone = tabHost.newTabSpec(TWOONE);
        twoone.setIndicator(TWOONE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent inboxIntent = new Intent(this, Page12.class);
        // Tab Content
        twoone.setContent(inboxIntent);

        // Outbox Tab
        TabHost.TabSpec twotwo = tabHost.newTabSpec(TWOTWO);
        twotwo.setIndicator(TWOTWO, getResources().getDrawable(R.drawable.icon_inbox));
        Intent outboxIntent = new Intent(this, Page22.class);
        twotwo.setContent(outboxIntent);

        // Profile Tab
        TabHost.TabSpec twothree = tabHost.newTabSpec(TWOTHREE);
        twothree.setIndicator(TWOTHREE, getResources().getDrawable(R.drawable.icon_inbox));
        Intent profileIntent = new Intent(this, Page32.class);
        twothree.setContent(profileIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(twoone); // Adding Inbox tab
        tabHost.addTab(twotwo); // Adding Outbox tab
        tabHost.addTab(twothree); // Adding Profile tab
    }
}
