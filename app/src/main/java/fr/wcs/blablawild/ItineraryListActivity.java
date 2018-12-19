package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ItineraryListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        final Intent input = getIntent();
        SearchModel sm = input.getParcelableExtra(ItinerarySearchActivity.EXTRA_MESSAGE);
        setTitle(sm.getDeparture() + " >> " + sm.getDestination());
        Toast.makeText(this, sm.getDate(), Toast.LENGTH_SHORT).show();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm", Locale.CANADA);

        ArrayList<TripModel> trips = new ArrayList<>();
        try {
            trips.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            trips.add(new TripModel("Bob", "Le Bricoleur", sdf.parse("10/05/2040-04:30"), 40));
            trips.add(new TripModel("JOOOOHN", "CENAAAAA", sdf.parse("36/02/2000-17:55"), 46));
            trips.add(new TripModel("Freddy", "Mercury", sdf.parse("21/02/2017-15:30"), 140));
            trips.add(new TripModel("Mickael", "Bay", sdf.parse("21/02/2017-15:30"), 78));
            trips.add(new TripModel("Chuck", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            trips.add(new TripModel("Serge", "Joint", sdf.parse("21/02/2017-15:30"), 15));
            trips.add(new TripModel("Eleonore", "Létoilepolaire", sdf.parse("21/02/2017-15:30"), 15));
            trips.add(new TripModel("Jean", "Bonbeur", sdf.parse("21/02/2017-15:30"), 15));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TripAdapter    adapter    = new TripAdapter(this, trips);
        ListView       tripList   = findViewById(R.id.display);
        tripList.setAdapter(adapter);
    }
}
