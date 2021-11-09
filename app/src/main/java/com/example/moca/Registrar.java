package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registrar extends AppCompatActivity {
    EditText etnombreusuario,etcontraseña,etemail,ettelefono,ettarjeta,etfecha,etcvv;
    TextView txmostrar;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        etnombreusuario=findViewById(R.id.keynombreusuario);
        etcontraseña=findViewById(R.id.keycontraseña);
        etemail=findViewById(R.id.keyemail);
        ettelefono=findViewById(R.id.keytelefono);
        ettarjeta=findViewById(R.id.keytarjetanum);
        etfecha=findViewById(R.id.keyfecha);
        etcvv=findViewById(R.id.keycvv);
        db = FirebaseFirestore .getInstance();

    }
    public void guardausuari(View view) {
        String nombre = etnombreusuario.getText().toString();
        String contraseña = etcontraseña.getText().toString();
        String email = etemail.getText().toString();
        String fecha = etfecha.getText().toString();
        int cvv = Integer.parseInt(etcvv.getText().toString()) ;
        int telefono = Integer.parseInt(ettelefono.getText().toString());
        int tarjeta = Integer.parseInt(ettarjeta.getText().toString());

        Map<String,Object> usuario = new HashMap<>();
        usuario.put("nombreusuario",nombre);
        usuario.put("contraseña",contraseña);
        usuario.put("email",email);
        usuario.put("telefono",telefono);
        usuario.put("tarjeta",tarjeta);
        usuario.put("fecha",fecha);
        usuario.put("cvv",cvv);
        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Usuario creado ʕ•́ᴥ•̀ʔっ",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("ERROR", "Error adding document", e);
                    }
                });
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}