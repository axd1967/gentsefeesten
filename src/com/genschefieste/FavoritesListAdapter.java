package com.genschefieste;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Favorite list adapter.
 */
public class FavoritesListAdapter extends BaseAdapter implements OnClickListener {
    private final Context context;
    private final List<Event> events;

    public FavoritesListAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    public int getCount() {
        return events.size();
    }

    public Event getItem(int position) {
        return events.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public void onClick(View view) {

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_list_item, null);
        }

        Event event = events.get(position);

        // TODO add additional row with the actual date.

        if (event != null) {

            // Change color of row.
            LinearLayout row = (LinearLayout) convertView.findViewById(R.id.event_row);
            if ((position % 2 ) == 0) {
                row.setBackgroundColor(Color.parseColor("#f6f6f6"));
            }
            else {
                row.setBackgroundColor(Color.parseColor("#ffffff"));
            }

            // Hour.
            TextView th = (TextView) convertView.findViewById(R.id.event_hour);
            String hour = event.getStartHour();
            if (hour.length() == 0) {
                hour = context.getString(R.string.event_whole_day);
            }
            th.setText(hour);

            // Title.
            TextView tt = (TextView) convertView.findViewById(R.id.event_title);
            String title = event.getTitle();
            tt.setText(title);
        }

        return convertView;
    }
}