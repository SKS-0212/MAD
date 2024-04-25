package com.example.experiment_31_fragmentbar;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.experiment_31_fragmentbar.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button homeButton, aboutButton, contactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeButton = findViewById(R.id.home_button);
        aboutButton = findViewById(R.id.about_button);
        contactButton = findViewById(R.id.contact_button);

        homeButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
        contactButton.setOnClickListener(this);

        // Display home fragment initially
        displayFragment(new HomeFragment());
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.home_button:
                fragment = new HomeFragment();
                break;
            case R.id.about_button:
                fragment = new AboutFragment();
                break;
            case R.id.contact_button:
                fragment = new ContactFragment();
                break;
        }
        displayFragment(fragment);
    }

    private void displayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}




