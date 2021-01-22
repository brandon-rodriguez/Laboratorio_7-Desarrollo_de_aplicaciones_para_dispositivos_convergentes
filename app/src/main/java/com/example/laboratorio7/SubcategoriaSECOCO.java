package com.example.laboratorio7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubcategoriaSECOCO extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategoria_s_e_c_o_c_o);
        String perfil = getIntent().getStringExtra("Perfil");
        TextView titulo = (TextView) findViewById(R.id.subactegoria_perfil);
        titulo.setText(perfil);
        ArrayList<String> opciones = getIntent().getStringArrayListExtra("Opciones");
        lista = (ListView) findViewById(R.id.subcategoria_lista);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, opciones);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayList<String> opciones = new ArrayList<>();



                if (perfil.equals("Diagnóstico")){
                    Intent nuevaActividad = new Intent(SubcategoriaSECOCO.this, finalSECOCO.class);
                    if(position==0){
                        nuevaActividad.putExtra("Contexto", "Sintomas");
                    }else{
                        nuevaActividad.putExtra("Contexto", "Examenes");
                    }
                    startActivity(nuevaActividad);
                }else if (perfil.equals("Seguimiento")){
                    if(position==0){
                        Intent nuevaActividad = new Intent(SubcategoriaSECOCO.this, finalSECOCO.class);
                        nuevaActividad.putExtra("Contexto", "Reporte ubicacion");
                        startActivity(nuevaActividad);
                    }else{
                        // Toca probarlo
                        Intent nuevaActividad = new Intent(SubcategoriaSECOCO.this, SubcategoriaSECOCO.class);
                        nuevaActividad.putExtra("Perfil", "Reportes");
                        ArrayList <String> opciones2 = new ArrayList<String>();
                        opciones2.add("Recorridos");
                        opciones2.add("Interacciones");
                        nuevaActividad.putExtra("Opciones", opciones2);
                        startActivity(nuevaActividad);
                    }
                }else if (perfil.equals("Zonas")){
                    Intent nuevaActividad = new Intent(SubcategoriaSECOCO.this, finalSECOCO.class);
                    if(position==0){
                        nuevaActividad.putExtra("Contexto", "Toma decisiones estados");
                    }else{
                        nuevaActividad.putExtra("Contexto", "Reportes");
                    }
                    startActivity(nuevaActividad);
                }else if (perfil.equals("Reportes")){
                    Intent nuevaActividad = new Intent(SubcategoriaSECOCO.this, finalSECOCO.class);
                    if(position==0){
                        nuevaActividad.putExtra("Contexto", "Recorridos");
                    }else{
                        nuevaActividad.putExtra("Contexto", "Interacciones");
                    }
                    startActivity(nuevaActividad);
                }


            }
        });

    }
}