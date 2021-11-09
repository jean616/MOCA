package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Cartelera extends AppCompatActivity {
    FirebaseFirestore db;
    List<Peliculas> pelisList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartelera);
        pelisList = new ArrayList<Peliculas>();
        db = FirebaseFirestore .getInstance();
        db.collection("peliculas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot peliss:task.getResult()){
                                String titulo = peliss.getData().get("titulo").toString();
                                String año = peliss.getData().get("año").toString();
                                String descripcion = peliss.getData().get("descripcion").toString();
                                String director = peliss.getData().get("director").toString();
                                String  precio =  peliss.getData().get("precio").toString();
                                pelisList.add(new Peliculas(titulo,año,descripcion,director,precio));
                            }
                            ListAdapter adaptere=new ListAdapter(pelisList,getApplicationContext());
                            RecyclerView recyclerView12 = findViewById(R.id.myRecycler2);
                            recyclerView12.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView12.setAdapter(adaptere);;
                        }else{
                            Log.w("APP","Error al traer documentos",task.getException());
                        }
                    }
                });
    }
}