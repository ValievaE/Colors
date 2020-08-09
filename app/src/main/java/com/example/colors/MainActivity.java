package com.example.colors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner spinnerLanguage;
    private Spinner spinnerColor;
    private String color = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utils.onActivityCreateTheme(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (color) {
                    case "Зеленый":
                        Utils.changeToTheme(MainActivity.this, R.style.GreenAppTheme);
                        break;
                    case "Синий":
                        Utils.changeToTheme(MainActivity.this, R.style.BlueAppTheme);
                        break;
                    case "Черный":
                        Utils.changeToTheme(MainActivity.this, R.style.BlackAppTheme);
                        break;
                }
            }
        });

    }

    private void initViews() {
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        spinnerColor = findViewById(R.id.spinnerColor);
        button = findViewById(R.id.button);
        initSpinnerColors();
        initSpinnerLanguages();
    }

    private void initSpinnerLanguages() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapterLanguages);
    }

    private void initSpinnerColors() {
        ArrayAdapter<CharSequence> adapterColors = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        adapterColors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adapterColors);
        spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color = spinnerColor.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}