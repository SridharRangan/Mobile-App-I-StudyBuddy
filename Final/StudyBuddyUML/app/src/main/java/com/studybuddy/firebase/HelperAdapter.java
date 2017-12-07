package com.studybuddy.firebase;

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.studybuddy.firebase.model.HelpItem;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class HelperAdapter extends ArrayAdapter<HelpItem>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    private Context context;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public HelperAdapter(Context context, ArrayList<HelpItem> words, int colorResourceId) {
        super(context, 0, words);
        this.context = context;
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.help_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final HelpItem currentItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID the_text_view.
        TextView className = (TextView) listItemView.findViewById(R.id.class_name);

        className.setText(currentItem.getClassName());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.class_description);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentItem.getAdditionalInformation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView userEmailText = (TextView) listItemView.findViewById(R.id.user_email);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        userEmailText.setText(currentItem.getUser().getEmail());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}