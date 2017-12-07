package com.studybuddy.firebase;

/**
 * Created by srangan on 11/25/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studybuddy.firebase.model.HelpItem;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;

    // ListView
    private ListView allItemsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        allItemsListView = (ListView) findViewById(R.id.helpItemListView);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome "+user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);

        TextView theHelp = (TextView) findViewById(R.id.help);

        // Set a click listener on that View
        theHelp.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the theHelp category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent helpIntent = new Intent(ProfileActivity.this, HelpActivity.class);

                // Start the new activity
                startActivity(helpIntent);
            }
        });

        // Find the View that shows the theTutor category
        TextView theTutor = (TextView) findViewById(R.id.tutor);

        // Set a click listener on that View
        theTutor.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the theTutor category is clicked on.
            @Override
            public void onClick(View view) {
                // Start the new activity
                Uri uri = Uri.parse("https://www.uml.edu/CLASS/Tutoring/tutor-schedule/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        initializeListView();
    }

    @Override
    public void onClick(View view) {
        if(view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void initializeListView() {
        FirebaseDatabaseHandler handler = new FirebaseDatabaseHandler(FirebaseDatabase.getInstance(), Constants.DatabaseFolderName);
        ArrayList<HelpItem> allItems = handler.getAllHelpItems();

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        HelperAdapter adapter = new HelperAdapter(this, allItems, R.color.background_color_1);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        allItemsListView.setAdapter(adapter);
    }
}