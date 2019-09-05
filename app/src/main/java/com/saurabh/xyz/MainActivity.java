package com.saurabh.xyz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    TextView headingTextView;
    TextView textTextView;
    FloatingActionButton fab;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headingTextView = findViewById(R.id.headingMainActivity_TV);
        textTextView = findViewById(R.id.textMainActivity_TV);

        fab = findViewById(R.id.floatingActionBar);
        sharedPreferences = getSharedPreferences("DATABASE", MODE_PRIVATE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnterActivity.class));
            }
        });

        if (sharedPreferences.getString("Heading", "").equals("")) {
            headingTextView.setText("No Heading");
            textTextView.setText("No Text");
            Toast.makeText(this, "Nothing to show!", Toast.LENGTH_SHORT).show();
        } else {
            headingTextView.setText(sharedPreferences.getString("Heading", ""));
            textTextView.setText(sharedPreferences.getString("Text", ""));
        }

        getSupportActionBar().setTitle("My Text Here");

    }

    @Override
    protected void onResume() {
        super.onResume();
        headingTextView.setText(sharedPreferences.getString("Heading", ""));
        textTextView.setText(sharedPreferences.getString("Text", ""));
    }
}
