package com.time.time;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class SelectedDay extends AppCompatActivity {

    int daySent, monthSent, yearSent, dayOfWeek;
    ListView dayEventList;
    private Decode d = new Decode();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_day);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dayEventList = (ListView) findViewById(R.id.day_events_list);


        //getting string from MainActivity.class
        daySent = getIntent().getExtras().getInt("day");
        monthSent = getIntent().getExtras().getInt("month");
        yearSent = getIntent().getExtras().getInt("year");
        dayOfWeek = getIntent().getExtras().getInt("dayoweek");

        //Change Activity title to date
        setTitle(" Events for: " + d.decodeDay(dayOfWeek) + ", " + daySent + "/" + monthSent + "/" + yearSent);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newEntry = new Intent(SelectedDay.this, NewEntry.class);
                newEntry.putExtra("day", daySent);
                newEntry.putExtra("month", monthSent);
                newEntry.putExtra("year", yearSent);
                newEntry.putExtra("dayoweek", dayOfWeek);
                startActivity(newEntry);
            }
        });


    }

}
