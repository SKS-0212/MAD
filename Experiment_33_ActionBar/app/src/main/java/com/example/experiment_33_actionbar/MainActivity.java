package com.example.experiment_33_actionbar;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private static final int CONTEXT_ITEM_1_ID = 1001;
    private static final int CONTEXT_ITEM_2_ID = 1002;
    private static final int CONTEXT_ITEM_3_ID = 1003;

    TextView textView;
    Button button;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Registering the textView for context menu
        registerForContextMenu(textView);
        // Registering the button for context menu
        registerForContextMenu(button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // Handle settings action
            Log.d("OptionsMenu", "Settings clicked");
            return true;
        } else if (id == R.id.action_refresh) {
            // Handle refresh action
            Log.d("OptionsMenu", "Refresh clicked");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);

        // Set the IDs for the context menu items programmatically
        if (v.getId() == R.id.textView) {
            menu.findItem(R.id.context_item1).setIcon(R.drawable.ic_launcher_background);
            menu.findItem(R.id.context_item2).setIcon(R.drawable.ic_launcher_background);
            menu.findItem(R.id.context_item3).setIcon(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case CONTEXT_ITEM_1_ID:
                // Handle context item 1
                textView.setText("Manan");
                return true;
            case CONTEXT_ITEM_2_ID:
                // Handle context item 2
                textView.setText("21BCS9258");
                return true;
            case CONTEXT_ITEM_3_ID:
                // Handle context item 3
                textView.setText("Chandigarh University");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // Method to show the popup menu
    public void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.show();
    }
}
