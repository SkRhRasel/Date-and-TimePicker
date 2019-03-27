package com.example.rasel.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Calendar calendar;
    int year,month,day,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

    }

    public void selectDate(View view) {

        DatePickerDialog datePickerDialog= new DatePickerDialog(this, dateSetListener,year,month,day);
        datePickerDialog.show();
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

            calendar.set(year,month,day);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy");
            ((Button)findViewById(R.id.dateButton)).setText(sdf.format(calendar.getTime()));

        }
    };

    public void selectTime(View view) {

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,timeSetListener,hour,min,false);
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int min) {
            calendar.set(0,0,0,hour,min);
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            //String time = sdf.format(calendar.getTime());
            ((Button)findViewById(R.id.timeButton)).setText(sdf.format(calendar.getTime()));

        }
    };


}
