package com.example.experiment_23_mail_sms_intent;

import android.app.Activity; import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.Toast;
public class MainActivity extends Activity { EditText emailAddressEditText;
    EditText subjectEditText;
    EditText messageEditText; Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

        emailAddressEditText = findViewById(R.id.emailAddressEditText);
        subjectEditText = findViewById(R.id.subjectEditText);


        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            String emailAddress = emailAddressEditText.getText().toString(); String subject = subjectEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (!emailAddress.isEmpty() && !subject.isEmpty() && !message.isEmpty()) {
                sendEmail(emailAddress, subject, message);
            } else {
                Toast.makeText(MainActivity.this, "Please enter email address, subject, and message", Toast.LENGTH_SHORT).show();
            }
        }
        });
    }

    private void sendEmail(String emailAddress, String subject, String message)
    { Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject); intent.putExtra(Intent.EXTRA_TEXT, message);
        try {
            startActivity(Intent.createChooser(intent, "Send email using"));
        } catch (android.content.ActivityNotFoundException ex)
        { Toast.makeText(MainActivity.this, "No email clients installed.",
                Toast.LENGTH_SHORT).show();
        }
    }
}