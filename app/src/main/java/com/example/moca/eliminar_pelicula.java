package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class eliminar_pelicula extends AppCompatActivity {
    FirebaseFirestore db;
    TextView tId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_pelicula);
        db = FirebaseFirestore.getInstance();
        tId=findViewById(R.id.ettIDpelis);
        db.collection("peliculas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot pelis:task.getResult()){
                                Log.w("APP","Error al traer documentos",task.getException());
                            }
                        }else{
                            Log.w("APP","Error al traer documentos",task.getException());
                        }
                    }
                });
    }
    public void EliminarPelis(View view) {
        String nombrepeli=tId.getText().toString();
        db.collection("peliculas")
                .document(nombrepeli)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),"Pelicula eliminada",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),adminvista.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("error","Error deleting document",e);
                    }
                });
    }
}