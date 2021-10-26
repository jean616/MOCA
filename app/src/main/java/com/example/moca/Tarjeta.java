package com.example.moca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tarjeta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta);
    }
    public void seguirr(View view) {
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}