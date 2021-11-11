package com.example.moca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminvista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminvista);
    }

    public void vercart(View view) {
        Intent intent=new Intent(getApplicationContext(),Cartelera.class);
        startActivity(intent);
    }

    public void agregarpelis(View view) {
        Intent intent=new Intent(getApplicationContext(),AgregarPelis.class);
        startActivity(intent);
    }
    public void entrarusuarios(View view) {
        Intent intent = new Intent(getApplicationContext(),RegistroUsuarios.class);
        startActivity(intent);
    }

    public void pasareliminar(View view) {
        Intent intent = new Intent(getApplicationContext(),Eliminarusuario.class);
        startActivity(intent);
    }

    public void EliminarPelicula(View view) {
        Intent intent = new Intent(getApplicationContext(),Eliminarusuario.class);
        startActivity(intent);
    }
}