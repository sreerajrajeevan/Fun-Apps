package com.example.chooseyourdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class Page2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Spinner spinner = findViewById(R.id.genderEditText);

        // Get the gender options array
        String[] genderOptions = getResources().getStringArray(R.array.Gender);

        // Add a default hint at the beginning of the array
        String[] genderOptionsWithHint = new String[genderOptions.length + 1];
        genderOptionsWithHint[0] = "Gender"; // Hint
        System.arraycopy(genderOptions, 0, genderOptionsWithHint, 1, genderOptions.length);

        // Use a default layout for spinner items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                genderOptionsWithHint
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button proceedButton = findViewById(R.id.proceedButton);
        final EditText nameET = findViewById(R.id.nameEditText);
        final EditText ageET = findViewById(R.id.ageEditText);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameET.getText().toString().isEmpty() || ageET.getText().toString().isEmpty()) {
                    Toast.makeText(Page2.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Page2.this, ChooseDateActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedText = adapterView.getItemAtPosition(i).toString();

        // Check if the selected item is the hint (first item)
        if (i == 0 && "Gender".equals(selectedText)) {
            // Handle the case where the hint is selected (nothing selected)
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, selectedText, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Handle the case where nothing is selected
        ((TextView) adapterView.getSelectedView()).setError("Please select a gender");
    }
}
