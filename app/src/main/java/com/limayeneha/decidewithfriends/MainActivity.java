package com.limayeneha.decidewithfriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String eventName;
    String eventVenue;
    String eventDate;
    String eventTime;
    EditText etEventName;
    EditText etEventVenue;
    DatePicker dpEventDate;
    TimePicker tpEventTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEventName = (EditText) findViewById(R.id.et_event_name);
        etEventVenue = (EditText) findViewById(R.id.et_event_venue);
        dpEventDate = (DatePicker) findViewById(R.id.dp_event_date);

        tpEventTime = (TimePicker) findViewById(R.id.tp_event_time);

        tpEventTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                eventTime = getTimeFromTimePicket(hourOfDay, minute);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_send, menu);
        return true;
    }

    public void sendToFriends(MenuItem item) {
        if(etEventName!=null)
            eventName = etEventName.getText().toString();
        if(etEventVenue!=null)
            eventVenue =etEventVenue.getText().toString();

        eventDate = getDateFromDatePicker();

        if(eventName.isEmpty() || eventVenue.isEmpty() || eventDate.isEmpty() || eventTime.isEmpty()) {
            Toast.makeText(this, "Missing info",Toast.LENGTH_SHORT).show();
        } else {
            Event event = new Event(eventName, eventVenue, eventDate, eventTime);
            event.save();
            Toast.makeText(this, "Event Name:" + eventName + " Event Venue:" + eventVenue + " Event Date:" + eventDate +
                    " Event Time:" + eventTime, Toast.LENGTH_LONG).show();
        }
    }

    public String getDateFromDatePicker(){
        String formattedDate = "";
        if(dpEventDate!=null) {
            int day = dpEventDate.getDayOfMonth();
            int month = dpEventDate.getMonth();
            int year = dpEventDate.getYear();

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);

            formattedDate = new SimpleDateFormat("MM-dd-yy").format(calendar.getTime());
        }

        return formattedDate;
    }

    public String getTimeFromTimePicket(int hour, int minute){
        String formattedTime = "";
        if(tpEventTime!=null) {

            Calendar calendarTmp = Calendar.getInstance();
            calendarTmp.set(Calendar.HOUR_OF_DAY, hour);
            calendarTmp.set(Calendar.MINUTE, minute);
            calendarTmp.set(Calendar.SECOND, 0);

            formattedTime = new SimpleDateFormat("HH:mm").format(calendarTmp.getTime());
        }

        return formattedTime;
    }
}
