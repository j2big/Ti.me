package com.time.time;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CalendarView calendar;
    ImageButton importButton, binButton, starredButton, addButton, settingsButton;
    int daySelected, monthSelected, yearSelected, dayOfWeek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView) findViewById(R.id.calender_view);
        importButton = (ImageButton) findViewById(R.id.import_calendar_button);
        binButton = (ImageButton) findViewById(R.id.bin_button);
        starredButton = (ImageButton) findViewById(R.id.starred_button);
        addButton = (ImageButton) findViewById(R.id.add_profiles_button);
        settingsButton = (ImageButton) findViewById(R.id.settings_button);

        //handle click action on home buttons
        importButton.setOnClickListener(this);
        binButton.setOnClickListener(this);
        starredButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);


        //handle click on calendar
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                daySelected = day;
                monthSelected = month;
                yearSelected = year;

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(calendar.getDate());
                dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

                //
                //
                Intent selected = new Intent(MainActivity.this, SelectedDay.class);
                selected.putExtra("day", daySelected);
                selected.putExtra("month", monthSelected);
                selected.putExtra("year", yearSelected);
                selected.putExtra("dayoweek", dayOfWeek);
                startActivity(selected);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startIntent(Class c) {
        Intent i = new Intent(this, c);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.import_calendar_button:
                startIntent(ImportCalendar.class);
                break;
            case R.id.bin_button:
                startIntent(Bin.class);
                break;
            case R.id.starred_button:
                startIntent(StarredEntries.class);
                break;
            case R.id.add_profiles_button:
                startIntent(AddProfile.class);
                break;
            case R.id.settings_button:
                startIntent(Settings.class);
                break;
        }
    }
}
