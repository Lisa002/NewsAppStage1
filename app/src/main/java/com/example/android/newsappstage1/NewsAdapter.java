package com.example.android.newsappstage1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<OneNews> {


    public NewsAdapter(Activity context, ArrayList<OneNews> news) {

        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        //get the currentNews with the right position and stores it in the variable currentNews
        OneNews currentNews = getItem(position);

        ImageView thumbnailImageView = (ImageView) listItemView.findViewById(R.id.thumbnail_image_view);
        Picasso.get().load(currentNews.getThumbnail()).into(thumbnailImageView);

        //gets the title text view from the xml and stores it in the variable titleTextView
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // gets the title of the news from the currentNews object and stores it in the variable title
        String title = currentNews.getTitle();
        //sets the title from the current news in the textview
        titleTextView.setText(title);

        //gets the rubric text view from the xml and stores it in the variable rubricTextView
        TextView rubricTextView = (TextView) listItemView.findViewById(R.id.rubric_text_view);
        // gets the  rubric of the news from the currentNews object and stores it in the variable rubric
        String rubric = currentNews.getRubric();
        //sets the rubric from the current news in the textview
        rubricTextView.setText(rubric);

        //gets the author text view from the xml and stores it in the variable authorTextView
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        // gets the  author of the news from the currentNews object and stores it in the variable author
        String author = currentNews.getauthor();
        //sets the author from the current news in the textview
        authorTextView.setText("author:" + " " + author);

        //gets the date text view from the xml and stores it in the variable dateTextView
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        //gets the time text view from the xml and stores it in the variable timeTextView
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // gets the Date and time of the news from the currentNews object and stores it in the variable dateAndTime
        String dateAndTime = currentNews.getDateAndTime();

        // creates a new SimpleDateFormat object with the ISODateformat that is uses in the Guardian API and stores
        // in the variable dateTimeFormat
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

        // creates a new SimpleDateFormat object with the format of the year that it should be shown and stores
        // in the variable dateFormat
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // creates a new SimpleDateFormat object with the format of the time that it should be shown and stores
        // in the variable timeFormat
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        try {

            // the dateTimeFormat from the currentNews object gets parsed and stored in the variable dateAndTimeParsed
            Date dateAndTimeParsed = dateTimeFormat.parse(dateAndTime);
            // the dateFormat becomes formatted
            String dateString = dateFormat.format(dateAndTimeParsed);
            // the timeFormat becomes formatted
            String timeString = timeFormat.format(dateAndTimeParsed);
            //sets the time from the current news in the timetextview with the right format
            timeTextView.setText(timeString);
            //sets the date from the current news in the datetextview with the right format
            dateTextView.setText(dateString);

        } catch (ParseException e) {

        }
        // returns the listItemView
        return listItemView;
    }

}




