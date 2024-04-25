package com.example.experiment_22_radiobutton;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get references to TextViews
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewUID = findViewById(R.id.textViewUID);
        TextView textViewGender = findViewById(R.id.textViewGender);
        TextView textViewBranch = findViewById(R.id.textViewBranch);
        TextView textViewSubjects = findViewById(R.id.textViewSubjects);

        // Get data passed from first activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String uid = extras.getString("uid");
            String gender = extras.getString("gender");
            String branch = extras.getString("branch");
            String subjects = extras.getString("subjects");

            // Display data in TextViews
            textViewName.setText("Name: " + name);
            textViewUID.setText("UID: " + uid);
            textViewGender.setText("Gender: " + gender);
            textViewBranch.setText("Branch: " + branch);
            textViewSubjects.setText("Subjects: " + subjects);
        }
    }
}
