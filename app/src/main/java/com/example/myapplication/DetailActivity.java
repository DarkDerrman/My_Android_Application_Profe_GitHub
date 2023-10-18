package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle parametros =  getIntent().getExtras();
        String nombre = parametros.getString("Nombre");

        TextView detailName = (TextView) findViewById(R.id.detailName);
        detailName.setText(nombre);
    }
}