package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class AgregarPelis extends AppCompatActivity {
    EditText etTitulo,etAño,etDescripcion,etDirector,etPrecio;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pelis);
        etTitulo=findViewById(R.id.keytitulo);
        etAño=findViewById(R.id.keyaño);
        etDescripcion=findViewById(R.id.keydescripcion);
        etDirector=findViewById(R.id.keydirector);
        etPrecio=findViewById(R.id.keyprecio);
        db = FirebaseFirestore .getInstance();
    }
    public void guardaPelis(View view) {
        String titulo = etTitulo.getText().toString();
        String año = etAño.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String director = etDirector.getText().toString();
        int precio = Integer.parseInt(etPrecio.getText().toString());

        Map<String, Object> Peliculas = new HashMap<>();
        Peliculas.put("nombrep", titulo);
        Peliculas.put("año", año);
        Peliculas.put("descripcion", descripcion);
        Peliculas.put("director", director);
        Peliculas.put("precio", precio);
        db.collection("peliculas")
                .add(Peliculas)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Pelicula Guardada ʕ•́ᴥ•̀ʔっ", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("ERROR", "Error adding document", e);
                    }
                });
        Intent intent = new Intent(getApplicationContext(), Cartelera.class);
        startActivity(intent);
    }
}