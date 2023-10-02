package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add extends AppCompatActivity {
    EditText name;
    EditText number;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name_input);
        number = findViewById(R.id.name_input);
        add_button = findViewById(R.id.add_person_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper mybd = new MyDatabaseHelper(add.this);
                mybd.AddPerson(name.getText().toString().trim(),
                number.getText().toString().trim());
            }
        });

    }
}