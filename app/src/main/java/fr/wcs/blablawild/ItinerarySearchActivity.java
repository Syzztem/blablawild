package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ItinerarySearchActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "fr.wcs.blablawild.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final EditText dep             = findViewById(R.id.departureIn);
        final EditText dest            = findViewById(R.id.destIn);
        final EditText dat             = findViewById(R.id.dateIn);
        final Button   toList          = findViewById(R.id.srcBt);
        final Intent   toItineraryList = new Intent(this, ItineraryListActivity.class);

        toList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String departure   = dep.getText().toString();
                String destination = dest.getText().toString();
                String date        = dat.getText().toString();
                if(TextUtils.isEmpty(dep.getText().toString()) || TextUtils.isEmpty((dest.getText().toString())))
                    Toast.makeText(ItinerarySearchActivity.this,R.string.DisplayErrorEmpty, Toast.LENGTH_SHORT).show();
                else {
                    toItineraryList.putExtra(EXTRA_MESSAGE, departure + " - " + destination);
                    startActivity(toItineraryList);
                }

            }
        });
    }
}
