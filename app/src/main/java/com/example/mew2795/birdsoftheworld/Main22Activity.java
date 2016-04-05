package com.example.mew2795.birdsoftheworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
    }
    public void sendMessage2(View view) {
        EditText name = (EditText)findViewById(R.id.EIDinput);
        Intent intent = new Intent(this, Main3Activity.class);
        if( name.getText().toString().length() != 0){
            startActivity(intent);
            finish();
        }
    }
}
