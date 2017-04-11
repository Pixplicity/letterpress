package com.pixplicity.fontview.sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

import com.pixplicity.fontview.utils.FontSpinnerAdapter;
import com.pixplicity.fontview.utils.FontUtil;

public class MainActivity extends AppCompatActivity {

    private Typeface mTypeface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Configure toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }

        // Load font manually
        mTypeface = FontUtil.getTypeface(this, "fonts/Action_Man.ttf");

        // Apply font to popup menu
        findViewById(R.id.bt_popup).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        // Apply font to Spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new FontSpinnerAdapter(this, mTypeface, R.array.spinner_list));
    }

    private void showPopupMenu(View anchorView) {
        PopupMenu popup = new PopupMenu(MainActivity.this, anchorView);
        popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                // ...
                return true;
            }
        });

        // Apply custom font to popup menu
        FontUtil.applyTypeface(popup.getMenu(), mTypeface);
        popup.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // Apply custom font to overflow menu
        FontUtil.applyTypeface(menu, mTypeface);
        return super.onPrepareOptionsMenu(menu);
    }
}
