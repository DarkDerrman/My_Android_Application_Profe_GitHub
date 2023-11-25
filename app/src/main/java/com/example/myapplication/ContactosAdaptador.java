package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactosAdaptador extends RecyclerView.Adapter<ContactosAdaptador.ContactosViewHolder>{
    private ArrayList<Contactos> contactos;
    public ContactosAdaptador(ArrayList<Contactos> contactos){
        this.contactos = contactos;
    }
    @NonNull
    @Override
    public ContactosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contactos, parent, false);
        return new ContactosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactosViewHolder contactosViewHolder, int position) {
        Contactos contacto = contactos.get(position);
        contactosViewHolder.cvName.setText(contacto.getNombre());
        contactosViewHolder.cvDireccion.setText(contacto.getDireccion());
        contactosViewHolder.cvCorreo.setText(contacto.getCorreo());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactosViewHolder extends RecyclerView.ViewHolder{
        TextView cvName;
        TextView cvDireccion;
        TextView cvCorreo;
        public ContactosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cvName = itemView.findViewById(R.id.cvName);
            this.cvDireccion = itemView.findViewById(R.id.cvDireccion);
            this.cvCorreo = itemView.findViewById(R.id.cvCorreo);
        }
    }
}
