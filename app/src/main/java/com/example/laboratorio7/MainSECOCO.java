package com.example.laboratorio7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainSECOCO extends AppCompatActivity {

    private ListView lista;
    private ArrayList<String> perfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_s_e_c_o_c_o);
        Log.d("creacion ", "onCreate: "+ "right");

        lista = (ListView) findViewById(R.id.perfiles_listView);
        perfiles = new ArrayList<>();
        perfiles.add("Diagnostico");
        perfiles.add("Seguimiento");
        perfiles.add("Zonas");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, perfiles);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayList<String> opciones = new ArrayList<String>();
                Intent nuevaActividad = new Intent(MainSECOCO.this, SubcategoriaSECOCO.class);

                if(position==0){
                    Log.i("------------- CLICK ", "onItemClick: "+ position+ " "+ id);
                    nuevaActividad.putExtra("Perfil", "Diagnóstico");
                    opciones.add("Sintomas");
                    opciones.add("Examenes");
                    nuevaActividad.putExtra("Opciones", opciones);
                }else if (position==1){
                    nuevaActividad.putExtra("Perfil", "Seguimiento");
                    opciones.add("Reporte Ubicaciones");
                    opciones.add("Reportes");
                    nuevaActividad.putExtra("Opciones", opciones);
                }else if (position==2){
                    nuevaActividad.putExtra("Perfil", "Zonas");
                    opciones.add("Toma decisiones estados");
                    opciones.add("Reportes");
                    nuevaActividad.putExtra("Opciones", opciones);
                }
                startActivity(nuevaActividad);
            }
        });
    }
}