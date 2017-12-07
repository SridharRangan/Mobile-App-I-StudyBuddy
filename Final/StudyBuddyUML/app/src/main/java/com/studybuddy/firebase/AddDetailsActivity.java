package com.studybuddy.firebase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.studybuddy.firebase.model.HelpItem;

public class AddDetailsActivity extends AppCompatActivity {

    EditText descriptionView;
    Button saveBtn;
    TextView classNameTxt;

    String className;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        context = getBaseContext();

        className = getIntent().getExtras().getString("ClassName");

        descriptionView = (EditText) findViewById(R.id.description);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        classNameTxt = (TextView) findViewById(R.id.classNameTitleTxt);
        classNameTxt.setText(className);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadToDatabase();
                Intent intent = new Intent(context, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void uploadToDatabase() {
        String description = descriptionView.getText().toString();

        HelpItem helpItem = new HelpItem(className, description);

        FirebaseDatabaseHandler handler = new FirebaseDatabaseHandler(FirebaseDatabase.getInstance(), Constants.DatabaseFolderName);
        handler.addNewHelpItem(helpItem);
    }
}
