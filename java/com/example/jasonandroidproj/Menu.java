package com.example.jasonandroidproj;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Handler;
public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Spinner mLanguage = (Spinner) findViewById(R.id.spLanguage);
        final TextView mTextView = (TextView) findViewById(R.id.textview);
        ArrayAdapter mAdapter = new ArrayAdapter<String>(Menu.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(Menu.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(Menu.this, "zh");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        com.spark.submitbutton.SubmitButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent i = new Intent(Menu.this, MapsActivity.class);
                        startActivity(i);

                        finish();
                    }
            },4000);

        };

      });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }



}

