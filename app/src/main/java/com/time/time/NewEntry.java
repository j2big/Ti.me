package com.time.time;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;

public class NewEntry extends AppCompatActivity {
    Decode d = new Decode();

    int daySent, monthSent, yearSent, dayOfWeek;
    Spinner profileSpinner, eventTypeSpinner, eventInviteAppsSpinner, reminderMinHr, reminderPeriod;
    EditText eventName, eventDescription, eventLocation, reminderNum;
    ImageButton eventLoacatonButton, addReminderButton;
    TimePicker eventTimeFrom, eventTimeTill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry_day);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //defining objects
        //spinners
        profileSpinner = (Spinner) findViewById(R.id.profile_spinner);
        eventTypeSpinner = (Spinner) findViewById(R.id.event_type_spinner);
        eventInviteAppsSpinner = (Spinner) findViewById(R.id.event_invite_apps_spinner);
        reminderMinHr = (Spinner) findViewById(R.id.new_entry_reminder_min_hr);
        reminderPeriod = (Spinner) findViewById(R.id.new_entry_reminder_period);
        //ImageButtons
        eventLoacatonButton = (ImageButton) findViewById(R.id.event_location_button);
        addReminderButton = (ImageButton) findViewById(R.id.add_reminder_button);
        //EditTexts
        eventName = (EditText) findViewById(R.id.event_name);
        eventDescription = (EditText) findViewById(R.id.event_description);
        eventLocation = (EditText) findViewById(R.id.event_location);
        reminderNum = (EditText) findViewById(R.id.new_entry_reminder_num);
        //TimePicker
        eventTimeFrom = (TimePicker) findViewById(R.id.event_time_from);
        eventTimeTill = (TimePicker) findViewById(R.id.event_time_till);


        //getting string from SelectedDay.class
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
