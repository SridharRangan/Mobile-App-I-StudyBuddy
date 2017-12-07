package com.example.android.StudyBuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the theHelp category
        TextView theHelp = (TextView) findViewById(R.id.help);

        // Set a click listener on that View
        theHelp.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the theHelp category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);

                // Start the new activity
                startActivity(helpIntent);
            }
        });

        // Find the View that shows the theTutor category
        TextView theTutor = (TextView) findViewById(R.id.tutor);

        // Set a click listener on that View
        theTutor.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the theTutor category is clicked on.
            @Override
            public void onClick(View view) {
                // Start the new activity
                Uri uri = Uri.parse("https://www.uml.edu/CLASS/Tutoring/tutor-schedule/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
