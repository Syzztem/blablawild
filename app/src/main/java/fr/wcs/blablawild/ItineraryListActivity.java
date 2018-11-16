package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        final Intent input = getIntent();
        String       title = input.getStringExtra(ItinerarySearchActivity.EXTRA_MESSAGE);
        setTitle(title);
    }
}
