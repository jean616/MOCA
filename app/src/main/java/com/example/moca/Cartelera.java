package com.example.moca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Cartelera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartelera);

        List<Peliculas> peliculass = new ArrayList();

        peliculass.add(new Peliculas("The batman","2022","Nuevo reinicio del popular personaje de DC Comics, Batman, que desarrollará en los comienzos del cruzado de la capa de Gotham con Robert Pattinson en el papel de Bruce Wayne / Batman. Esta historia contará con varios villanos icónicos del caballero oscuro.","s/38.00","Matt Reeves",R.drawable.bats));
        peliculass.add(new Peliculas("Spider man no way home","2021","Spider-Man, nuestro amigable héroe vecino está desenmascarado y ya no puede separar su vida normal de los grandes desafíos de ser un superhéroe. Cuando le pide ayuda al Doctor Strange, lo que está en juego se vuelve aún más peligroso, lo que lo obliga a descubrir lo que realmente significa ser Spider-Man","s/48.00","Jon Watts",R.drawable.spd));
        peliculass.add(new Peliculas("The Flash","2022","Esta nueva película de superhéroes seguirá la línea de cómics de DC conocida como Flashpoint, en la que Flash debe realizar un viaje en el tiempo con el objetivo de salvar la vida de su madre y provoca múltiples cambios en la línea temporal de DC.","s/28.00","Andrés Muschietti",R.drawable.flash));
        peliculass.add(new Peliculas("The owl house","2022","Luz se siente culpable de que Eda haya perdido sus poderes, por lo que se encamina en una busca de una lucrativa recompensa para ayudar a la Casa Búho.","s/16.00","Dana Terrace",R.drawable.owl));
        peliculass.add(new Peliculas("Amphibia","2021"," Anne y los Plantars teletransportados de Amphibia a el hogar de Anne, Los Ángeles donde la familia de ranas tendrá que aprender sobre el mundo moderno y encontrar la manera de volver a casa","s/18.00","Matt Braly",R.drawable.anne));
        ListAdapter adapter = new ListAdapter(peliculass,this);
        RecyclerView mircala= findViewById(R.id.myRecycler);
        mircala.setLayoutManager(new LinearLayoutManager(this));
        mircala.setAdapter(adapter);
    }
}