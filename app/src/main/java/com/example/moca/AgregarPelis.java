package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AgregarPelis extends AppCompatActivity {
    EditText ettitulo,etaño,etdescripcion,etdirector,etprecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pelis);
        ettitulo =findViewById(R.id.keytitulo);
        etaño =findViewById(R.id.keyaño);
        etdescripcion =findViewById(R.id.keydescripcion);
        etdirector =findViewById(R.id.keydirector);
        etprecio =findViewById(R.id.keyprecio);
        FirebaseFirestore db = FirebaseFirestore .getInstance();
        db.collection("peliculas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){

                        }else{
                            Log.w("APP","Error al traer documentos",task.getException());
                        }
                    }
                });
    }
    public void agregarpeli(View view){

    }
}