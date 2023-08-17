package sg.edu.rp.c346.id22045554.demoweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Weather> alWeather;

    public CustomAdapter(Context context, int resource, ArrayList<Weather> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        alWeather = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvArea = rowView.findViewById(R.id.textViewArea);
        TextView tvForecast = rowView.findViewById(R.id.textViewForecast);
        ImageView iv = rowView.findViewById(R.id.imageView);

        Weather currentItem = alWeather.get(position);
        tvArea.setText(currentItem.getArea());
        String img = "";
        if (currentItem.getForecast().equalsIgnoreCase("Partly Cloudy (Day)")) {
            currentItem.setForecast("Partly Cloudy");
            img = "https://img.icons8.com/?size=512&id=jM1PIbVZ2gYv&format=png";
        } else if (currentItem.getForecast().equalsIgnoreCase("Light Showers") || currentItem.getForecast().equalsIgnoreCase("Showers")) {
            img = "https://img.icons8.com/?size=512&id=QqVqJ6JGmC7i&format=png";
        } else {
            currentItem.setForecast("Thunder Showers");
            img = "https://img.icons8.com/?size=512&id=IN1cxDtoi3Q0&format=png";
        }

        tvForecast.setText(currentItem.getForecast());

        if(currentItem.getForecast().isEmpty()){
            iv.setImageResource(R.drawable.na);
        } else {
            Picasso.with(rowView.getContext()).load(img).into(iv);
        }



        return rowView;
    }
}
