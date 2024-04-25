package com.example.experiment_32_absolutelayout;
import android.os.Bundle;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity; public class MainActivity extends AppCompatActivity {
    TextView heading, subHeading; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
// Referencing the TextViews
        heading = findViewById(R.id.heading); subHeading = findViewById(R.id.subHeading);
// Setting text dynamically heading.setText("Chandigarh University"); subHeading.setText("Computer Science Portal");
    }
}