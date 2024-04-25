package com.example.experiment_31_fragmentbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;


public class ContactFragment extends Fragment {

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        // Initialize views
        Button sendButton = view.findViewById(R.id.send_button);

        // Set click listener for send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to send an email
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tanishasingh2559@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, ((EditText) view.findViewById(R.id.subject_edit_text)).getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, ((EditText) view.findViewById(R.id.message_edit_text)).getText().toString());

                // Explicitly set the package for the Gmail app
                emailIntent.setPackage("com.google.android.gm");

                // Verify that the intent can be resolved
                if (emailIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    // Start the activity (sending email)
                    startActivity(emailIntent);
                } else {
                    // If Gmail app is not available, try sending using other email apps
                    emailIntent.setPackage(null);
                    if (emailIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    } else {
                        // Display a message indicating that no email app is available
                        Toast.makeText(getContext(), "No email app found", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        return view;
    }
}
