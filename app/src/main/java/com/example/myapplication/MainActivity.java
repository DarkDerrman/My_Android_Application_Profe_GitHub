package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.db.DataBase;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();
        Toast.makeText(this, getResources().getString(R.string.oncreate), Toast.LENGTH_LONG).show();

        //ArrayList<Contactos> contactos = new ArrayList<Contactos>();
        //contactos.add(new Contactos("Pedro", "Pedro House", "pedro@email.com"));
        //contactos.add(new Contactos("Juan", "Juan House", "juan@email.com"));
        //contactos.add(new Contactos("Diego", "Diego House", "diego@email.com"));

        DataBase db = new DataBase(MainActivity.this);
        ArrayList<Contactos> contactos = db.obtenerContactos();

        ArrayList<String> nombresContacto = new ArrayList<String>();

        for (Contactos contacto: contactos
             ) {
            nombresContacto.add(contacto.getNombre());
        }
        ListView miListView = findViewById(R.id.milista);
        miListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nombresContacto));

        miListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("contacto", contactos.get(position));
                startActivity(intent);
            }
        });
    }

    public void agregarFAB(){
        Button myButt = (Button) findViewById(R.id.button);
        myButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), "asd", Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "soy snack", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, getResources().getString(R.string.onstart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getResources().getString(R.string.onresume), Toast.LENGTH_LONG).show();
    }
    // corriendo

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, getResources().getString(R.string.onrestart), Toast.LENGTH_LONG).show();
        DataBase db = new DataBase(MainActivity.this);
        ArrayList<Contactos> contactos = db.obtenerContactos();

        ArrayList<String> nombresContacto = new ArrayList<String>();

        for (Contactos contacto: contactos
        ) {
            nombresContacto.add(contacto.getNombre());
        }
        ListView miListView = findViewById(R.id.milista);
        miListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nombresContacto));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, getResources().getString(R.string.onpause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, getResources().getString(R.string.onstop), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, getResources().getString(R.string.ondestroy), Toast.LENGTH_LONG).show();
    }
}