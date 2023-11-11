package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.db.DataBase;
import com.google.android.material.snackbar.Snackbar;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        agregarBtn();
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