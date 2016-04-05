package com.example.mew2795.birdsoftheworld;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView idView;
    EditText birdType;
    EditText datos;
    EditText los;
    EditText notes;

    AdapterView.OnItemSelectedListener spinner = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Object var = parent.getItemAtPosition(pos);
            if (var == "Add a bird sighting") {
                newProduct(idView);
            }}

        @Override
        public void onNothingSelected (AdapterView < ? > parent){
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main3activity);

            idView = (TextView) findViewById(R.id.id);
            birdType = (EditText) findViewById(R.id.birdtype);
            datos = (EditText) findViewById(R.id.datos);
            los = (EditText) findViewById(R.id.los);
            notes = (EditText) findViewById(R.id.notes);
    }

    public void radio1(View view) {
            Intent intent = new Intent(this, Main4Activity.class);
            startActivity(intent);
        }

    public void radio2(View view) {
            Intent intent = new Intent(this, Main5Activity.class);
            startActivity(intent);
        }

    public void radio3(View view) {
            Intent intent = new Intent(this, Main6Activity.class);
            startActivity(intent);
        }

    public void radio4(View view) {
            Intent intent = new Intent(this, Main7Activity.class);
            startActivity(intent);
        }

    public void quitapp(View view) {
            finish();
        }
    public void newProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        String bird = birdType.getText().toString();
        String date = datos.getText().toString();
        String location = los.getText().toString();
        String note = notes.getText().toString();

        data product =
                new data(bird, date,location,note);

        dbHandler.addProduct(product);
        birdType.setText("");
        datos.setText("");
        los.setText("");
        notes.setText("");
    }
}
