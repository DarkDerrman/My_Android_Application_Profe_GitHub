package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        agregarBotones();

        //Bundle parametros =  getIntent().getExtras();
        Contactos contacto = (Contactos) getIntent().getSerializableExtra("contacto");
        //String nombre = parametros.getString("Nombre");

        TextView detailName = (TextView) findViewById(R.id.detailName);
        detailName.setText(contacto.getNombre());

        TextView detailAddr = (TextView) findViewById(R.id.detailAddr);
        detailAddr.setText(contacto.getDireccion());

        TextView detailEmail = (TextView) findViewById(R.id.detailEmail);
        detailEmail.setText(contacto.getCorreo());
    }
    public void guardarPreferencias(View v){
        SharedPreferences myShared = getSharedPreferences("misDatos", MODE_PRIVATE);
        SharedPreferences.Editor editor = myShared.edit();

        EditText edtNombre = (EditText) findViewById(R.id.edtNombre);
        EditText edtCorreo = (EditText) findViewById(R.id.edtCorreo);

        editor.putString("nombre", edtNombre.getText().toString());
        editor.putString("correo", edtCorreo.getText().toString());
        editor.commit();

        Toast.makeText(DetailActivity.this, "Se han guardados sus preferencias", Toast.LENGTH_SHORT).show();
        edtNombre.setText("");
        edtCorreo.setText("");
    }
    public void mostrarPreferencias(View v){
        SharedPreferences myShared = getSharedPreferences("misDatos", MODE_PRIVATE);

        String nombre = myShared.getString("nombre", "No existe Nombre");
        String correo = myShared.getString("correo", "No existe Correo");

        String mensaje = "\nNombre: " + nombre + "\nCorreo: " + correo;
        TextView tvPreferencias = (TextView) findViewById(R.id.tvPrefetencias);
        tvPreferencias.setText(mensaje);
    }

    public void agregarBotones(){
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPreferencias(view);
            }
        });

        Button btnMostrar = (Button) findViewById(R.id.btnMostar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarPreferencias(view);
            }
        });
    }
}