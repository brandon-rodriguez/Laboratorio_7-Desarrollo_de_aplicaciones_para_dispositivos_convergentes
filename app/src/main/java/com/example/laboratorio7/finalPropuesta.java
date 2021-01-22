package com.example.laboratorio7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class finalPropuesta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_propuesta);
        String tituloS = getIntent().getStringExtra("Contexto");
        TextView titulo = (TextView) findViewById(R.id.final_propuesta_contexto);
        titulo.setText(tituloS);
    }
}