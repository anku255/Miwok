package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anku on 1/6/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    // An integer variable to store color Resource Id
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from currentWord object
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from currentWord object and
        // Set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());


        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView iconImage = (ImageView) listItemView.findViewById(R.id.emoji_icon);

        // Checking if the currentWord has an Image
        if(currentWord.hasImage()) {
            // Get the imageResource ID from current word object and set it to iconImage
            iconImage.setImageResource(currentWord.getImageResourceId());
            // Setting visibility 'VISIBLE'
            iconImage.setVisibility(View.VISIBLE);
        }
        else {
            // Otherwise hiding the imageView (Setting visibilty to 'GONE')
            iconImage.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set background color of the textContainer view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
