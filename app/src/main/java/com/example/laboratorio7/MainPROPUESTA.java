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

public class MainPROPUESTA extends AppCompatActivity {

    private ListView lista;
    ArrayList<String> opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_p_r_o_p_u_e_s_t);

        String tituloS = getIntent().getStringExtra("Titulo");
        TextView titulo = (TextView) findViewById(R.id.tv_titulo);
        titulo.setText(tituloS);
        opciones = getIntent().getStringArrayListExtra("Opciones");
        lista = (ListView) findViewById(R.id.main_propuesta_list);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, opciones);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent nuevaActividad = new Intent(MainPROPUESTA.this, MainPROPUESTA.class);
                ArrayList <String> opcionesEnvio  = new ArrayList<String>();
                if (tituloS.equals("Productos")){
                    if(position==0){
                        nuevaActividad.putExtra("Titulo", "Bisuteria");
                        opcionesEnvio.add("Collares");
                        opcionesEnvio.add("Aretes");
                        opcionesEnvio.add("Candongas");
                        opcionesEnvio.add("Juegos");
                        opcionesEnvio.add("Aretas");
                        nuevaActividad.putExtra("Opciones", opcionesEnvio);
                    }else if (position==1){
                        nuevaActividad.putExtra("Titulo", "Perfumes");
                        opcionesEnvio.add("Femenino");
                        opcionesEnvio.add("Masculino");
                        nuevaActividad.putExtra("Opciones", opcionesEnvio);
                    }else{
                        nuevaActividad.putExtra("Titulo", "Bolsos");
                        opcionesEnvio.add("Formales");
                        opcionesEnvio.add("Sport");
                        opcionesEnvio.add("Grandes");
                        opcionesEnvio.add("Pequeños");
                        nuevaActividad.putExtra("Opciones", opcionesEnvio);
                    }
                    startActivity(nuevaActividad);
                }else if (tituloS.equals("Bisuteria") ){
                    nuevaActividad.putExtra("Titulo",opciones.get(position) );
                    opcionesEnvio.add("Acero");
                    opcionesEnvio.add("Oro");
                    opcionesEnvio.add("Plata");
                    nuevaActividad.putExtra("Opciones", opcionesEnvio);
                    startActivity(nuevaActividad);

                }else if (tituloS.equals("Collares") ||tituloS.equals("Aretes") ||tituloS.equals("Candongas") ||tituloS.equals("Juegos") ||tituloS.equals("Aretas") ){
                    nuevaActividad =  new Intent(MainPROPUESTA.this, finalPropuesta.class);;
                    nuevaActividad.putExtra("Contexto","Accesorio: "+tituloS +" en "+opciones.get(position));
                    startActivity(nuevaActividad);
                } else if (tituloS.equals("Perfumes") ){
                    nuevaActividad.putExtra("Titulo", opciones.get(position));
                    opcionesEnvio.add("Dulce");
                    opcionesEnvio.add("Especial");
                    opcionesEnvio.add("Cotidiano");
                    nuevaActividad.putExtra("Opciones", opcionesEnvio);
                    startActivity(nuevaActividad);

                }else if (tituloS.equals("Femenino") ||tituloS.equals("Masculino")  ){
                    nuevaActividad =  new Intent(MainPROPUESTA.this, finalPropuesta.class);;
                    nuevaActividad.putExtra("Contexto","Perfume: "+tituloS +" con aroma "+opciones.get(position));
                    startActivity(nuevaActividad);
                }else if (tituloS.equals("Bolsos") ){
                    nuevaActividad =  new Intent(MainPROPUESTA.this, finalPropuesta.class);;
                    nuevaActividad.putExtra("Contexto","Bolso: "+opciones.get(position));
                    startActivity(nuevaActividad);
                }


            }
        });
    }
}