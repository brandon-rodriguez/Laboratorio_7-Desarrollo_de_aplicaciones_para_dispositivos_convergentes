package com.example.laboratorio7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class finalSECOCO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_s_e_c_o_c_o);
        String contexto = getIntent().getStringExtra("Contexto");
        TextView titulo = (TextView) findViewById(R.id.final_contexto);
        titulo.setText(contexto);
    }
}