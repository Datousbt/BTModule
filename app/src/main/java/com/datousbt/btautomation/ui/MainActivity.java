package com.datousbt.btautomation.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.datousbt.btautomation.R;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {

        super.onCreate(
                savedInstanceState);

        setContentView(
                R.layout.activity_main);

        FloatingActionButton add =
                findViewById(
                        R.id.add);

        add.setOnClickListener(
                v -> startActivity(
                        new Intent(
                                this,
                                DeviceEditActivity.class
                        )
                ));
    }
}