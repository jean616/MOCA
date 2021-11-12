package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
        db = FirebaseFirestore.getInstance();
        db.collection("peliculas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot peliss : task.getResult()) {
                                String titulo = peliss.getData().get("titulo").toString();
                                String año = peliss.getData().get("año").toString();
                                String descripcion = ("Descripcion"+"\n"+peliss.getData().get("descripcion").toString());
                                String director =("Director:"+peliss.getData().get("director").toString());
                                String precio = ("s/"+peliss.getData().get("precio").toString());
                                pelisList.add(new Peliculas(titulo, año, descripcion, director, precio));
                            }
                            ListAdapter adapter = new ListAdapter(pelisList, getApplicationContext());
                            RecyclerView recyclerView12 = findViewById(R.id.myRecycler2);
                            recyclerView12.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView12.setAdapter(adapter);
                            ;
                        } else {
                            Log.w("APP", "Error al traer documentos", task.getException());
                        }
                    }
                });
        Toolbar toolbar = findViewById(R.id.new_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            /*case R.id.item1:
                Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT);
                return true;*/
            case R.id.item2:
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}