package com.example.moca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
    }

    public void seguir(View view) {
        Intent intent=new Intent(getApplicationContext(),Tarjeta.class);
        startActivity(intent);
    }
}