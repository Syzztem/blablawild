package fr.wcs.blablawild;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TripAdapter extends ArrayAdapter {
    public TripAdapter(Context context, ArrayList<TripModel> trips){
        super(context, 0, trips);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        TripModel trip = (TripModel) getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);

        TextView date      = convertView.findViewById(R.id.time);
        TextView price     = convertView.findViewById(R.id.price);
        TextView firstname = convertView.findViewById(R.id.firstname);
        TextView lastname  = convertView.findViewById(R.id.lastname);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm", Locale.CANADA);

        if (trip != null) {
            date.setText(sdf.format(trip.getDate()));
            firstname.setText(trip.getFirstname());
            lastname.setText(trip.getLastname());
            price.setText("$" + trip.getPrice());
        }
        return convertView;
    }
}
