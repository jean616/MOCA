package com.example.moca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {
    EditText attnombre,attcontraseña;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        attnombre=findViewById(R.id.ettnombreusuario);
        attcontraseña=findViewById(R.id.ettpass);
        db=FirebaseFirestore.getInstance();

    }
    public void IniciarSesion(View view) {
        String usuario = attnombre.getText().toString();
        String pass = attcontraseña.getText().toString();
        db.collection("usuarios")
                .whereEqualTo("nombreusuario",usuario)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            if(task.getResult().isEmpty()){
                                    Log.d("Error","usuario no encontrado" );
                                Toast.makeText(getApplicationContext(),"usuario y/o contraseña no coinciden ʕ•́ᴥ•̀ʔっ",Toast.LENGTH_SHORT).show();
                            }else{
                                for(QueryDocumentSnapshot document :task.getResult()){
                                    if(pass.equals(document.getData().get("contraseña"))){
                                        String nombre  = document.getData().get("nombreusuario").toString();
                                        String tipo  = document.getData().get("tipo").toString();
                                        Log.d("Exito","acceso concedido");
                                        if(tipo.equals("administrador")){
                                            Log.d("Exito","acceso concedido administrador");
                                            Intent intent = new Intent(getApplicationContext(),adminvista.class);
                                            startActivity(intent);
                                        }else {
                                            Log.d("fallo","No es administrador");
                                            Intent intent = new Intent(getApplicationContext(),Cartelera.class);
                                            startActivity(intent);
                                        }
                                    }else {
                                        Log.d("Error","usuario y/o contraseña no coinciden");
                                        Toast.makeText(getApplicationContext(),"usuario y/o contraseña no coinciden ʕ•́ᴥ•̀ʔっ",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }else{
                            Log.w("Errror","Error en la ejecucion",task.getException());
                        }
                    }
                });
    }
}