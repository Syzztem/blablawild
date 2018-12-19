package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ItinerarySearchActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "fr.wcs.blablawild.searchmodel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final EditText dep             = findViewById(R.id.departureIn);
        final EditText dest            = findViewById(R.id.destIn);
        final EditText dat             = findViewById(R.id.dateIn);
        final Button   toList          = findViewById(R.id.srcBt);
        final Intent   toItineraryList = new Intent(this, ItineraryListActivity.class);
        final Calendar calendar        = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(dat, calendar);
            }
        };


        dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ItinerarySearchActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        toList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String departure   = dep.getText().toString();
                String destination = dest.getText().toString();
                String date        = dat.getText().toString();
                if(TextUtils.isEmpty(departure) || TextUtils.isEmpty((destination)) || TextUtils.isEmpty(date))
                    Toast.makeText(ItinerarySearchActivity.this,R.string.DisplayErrorEmpty, Toast.LENGTH_SHORT).show();
                else {
                    SearchModel sm = new SearchModel(departure, destination, date);
                    toItineraryList.putExtra(EXTRA_MESSAGE, sm);
                    startActivity(toItineraryList);
                }

            }
        });
    }

    private void updateLabel(EditText dat, Calendar calendar) {
        String           format        = "dd/MM/yy";
        SimpleDateFormat sdf           = new SimpleDateFormat(format, Locale.CANADA);
        dat.setText(sdf.format(calendar.getTime()));
    }

}
