package com.saurabh.xyz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterActivity extends AppCompatActivity {

    EditText headingEditText;
    EditText textEditText;
    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        button = findViewById(R.id.buttonEnter_BT);
        textEditText = findViewById(R.id.textEnter_ET);
        headingEditText = findViewById(R.id.headingEnter_ET);
        sharedPreferences = getSharedPreferences("DATABASE",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        headingEditText.setText(sharedPreferences.getString("Heading",""));
        textEditText.setText(sharedPreferences.getString("Text",""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save Code SharedPreference

                editor.putString("Heading",headingEditText.getText().toString());
                editor.putString("Text", textEditText.getText().toString());
                editor.commit();

                finish();
            }
        });

        getSupportActionBar().setTitle("My Text Here");
    }
}
