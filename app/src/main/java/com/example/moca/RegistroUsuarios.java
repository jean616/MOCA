package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RegistroUsuarios extends AppCompatActivity {
    FirebaseFirestore db;
    List<usuario> usuarioList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
         usuarioList = new ArrayList<>();
        db = FirebaseFirestore .getInstance();
        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot usuar:task.getResult()){
                                String nombreu = usuar.getData().get("nombreusuario").toString();
                                String contraseña = usuar.getData().get("contraseña").toString();
                                String email = usuar.getData().get("email").toString();
                                usuarioList.add(new usuario(nombreu,contraseña,email));
                            }
                            ListAdapterr adaptera=new ListAdapterr(usuarioList,getApplicationContext());
                            RecyclerView recyclerView = findViewById(R.id.myRecycler1);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView.setAdapter(adaptera);;
                        }else{
                            Log.w("APP","Error al traer documentos",task.getException());
                        }
                    }
                });
    }
}