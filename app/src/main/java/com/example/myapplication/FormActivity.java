package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.db.DataBase;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {
    ArrayList<Contactos> contactos;
    RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        agregarBtn();

        DataBase db = new DataBase(FormActivity.this);
        contactos = db.obtenerContactos();
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        ContactosAdaptador adaptador = new ContactosAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void agregarBtn(){
        Button btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase db = new DataBase(FormActivity.this);
                EditText etNombre = (EditText) findViewById(R.id.etNombre);
                EditText etDireccion = (EditText) findViewById(R.id.etDireccion);
                EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
                ContentValues contentValues = new ContentValues();
                contentValues.put("nombre", etNombre.getText().toString());
                contentValues.put("direccion", etDireccion.getText().toString());
                contentValues.put("correo", etCorreo.getText().toString());
                db.agregarContacto(contentValues);
                etNombre.setText("");
                etDireccion.setText("");
                etCorreo.setText("");
                Snackbar.make(view, "Contacto Ingresado", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}