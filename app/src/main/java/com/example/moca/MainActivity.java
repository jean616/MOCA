package com.example.moca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Siguiente(View view) {
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }

    public void iniciar(View view) {
        Intent intent=new Intent(getApplicationContext(),Registrar.class);
        startActivity(intent);
    }
}