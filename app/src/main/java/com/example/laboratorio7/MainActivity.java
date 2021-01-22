package com.example.laboratorio7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_proyecto = (Button) findViewById(R.id.btn_Proyecto);
        btn_proyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nueva = new Intent(MainActivity.this, MainSECOCO.class);
                startActivity(nueva);
            }
        });

        Button btn_propuesta = (Button) findViewById(R.id.btn_propuesta_adicional);
        btn_propuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nueva = new Intent(MainActivity.this, MainPROPUESTA.class);
                nueva.putExtra("Titulo", "Productos");
                ArrayList<String> opciones = new ArrayList<String>();
                opciones.add("Bisuteria");
                opciones.add("Perfumes");
                opciones.add("Accesorios");
                nueva.putExtra("Opciones", opciones);
                startActivity(nueva);
            }
        });
    }
}