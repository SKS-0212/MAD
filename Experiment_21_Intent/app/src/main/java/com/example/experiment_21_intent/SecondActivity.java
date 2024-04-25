package com.example.experiment_21_intent;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewName, textViewUID, textViewEmail, textViewContact, textViewAddress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.textViewName);
        textViewUID = findViewById(R.id.textViewUID);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewContact = findViewById(R.id.textViewContact);
        textViewAddress = findViewById(R.id.textViewAddress);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String uid = intent.getStringExtra("uid");
        String email = intent.getStringExtra("email");
        String contact = intent.getStringExtra("contact");
        String address = intent.getStringExtra("address");

        textViewName.setText("Name: " + name);
        textViewUID.setText("UID: " + uid);
        textViewEmail.setText("Email: " + email);
        textViewContact.setText("Contact: " + contact);
        textViewAddress.setText("Address: " + address);
    }
}
