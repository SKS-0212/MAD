package com.example.experiment_22_radiobutton;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextUID;
    RadioGroup radioGroupGender, radioGroupBranch;
    CheckBox checkBoxDSA, checkBoxMAD, checkBoxCC, checkBoxQuantum, checkBoxJava;
    Button buttonSubmit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextUID = findViewById(R.id.editTextUID);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupBranch = findViewById(R.id.radioGroupBranch);
        checkBoxDSA = findViewById(R.id.checkBoxDSA);
        checkBoxMAD = findViewById(R.id.checkBoxMAD);
        checkBoxCC = findViewById(R.id.checkBoxCC);
        checkBoxQuantum = findViewById(R.id.checkBoxQuantum);
        checkBoxJava = findViewById(R.id.checkBoxJava);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gather input data
                String name = editTextName.getText().toString();
                String uid = editTextUID.getText().toString();
                String gender = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                String branch = ((RadioButton)findViewById(radioGroupBranch.getCheckedRadioButtonId())).getText().toString();
                StringBuilder subjects = new StringBuilder();
                if (checkBoxDSA.isChecked())
                    subjects.append("DSA, ");
                if (checkBoxMAD.isChecked())
                    subjects.append("MAD, ");
                if (checkBoxCC.isChecked())
                    subjects.append("CC, ");
                if (checkBoxQuantum.isChecked())
                    subjects.append("Quantum, ");
                if (checkBoxJava.isChecked())
                    subjects.append("Java");

                // Start second activity and pass data
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("uid", uid);
                intent.putExtra("gender", gender);
                intent.putExtra("branch", branch);
                intent.putExtra("subjects", subjects.toString());
                startActivity(intent);
            }
        });
    }
}