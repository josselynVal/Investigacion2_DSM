package com.edu.sv.ejercicio.informacion;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.edu.sv.ejercicio.R;
import com.edu.sv.ejercicio.datos.Pais;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PersonasActivity extends AppCompatActivity {
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refPais = database.getReference("pais");


    Query consultaOrdenada = refPais.orderByChild("nombre");

    List<Pais> pais;
    ListView listaPais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        inicializar();

    }

    private void inicializar() {
        FloatingActionButton fab_agregar= findViewById(R.id.fab_agregar);
        listaPais = findViewById(R.id.ListaPais);

        // Cuando el usuario haga clic en la lista (para editar registro)
        listaPais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), AddPersonaActivity.class);

                intent.putExtra("accion","e"); // Editar
                intent.putExtra("key", pais.get(i).getKey());
                intent.putExtra("nombre",pais.get(i).getNombre());
                intent.putExtra("capital",pais.get(i).getCapital());
                intent.putExtra("idioma",pais.get(i).getIdioma());
                intent.putExtra("moneda",pais.get(i).getMoneda());
                intent.putExtra("información",pais.get(i).getInf());
                startActivity(intent);
            }
        });

     listaPais.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                AlertDialog.Builder ad = new AlertDialog.Builder(PersonasActivity.this);
                ad.setMessage("Está seguro de eliminar registro?")
                        .setTitle("Confirmación");

                ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        PersonasActivity.refPais
                                .child(pais.get(position).getKey()).removeValue();

                        Toast.makeText(PersonasActivity.this,
                                "Registro borrado!",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(PersonasActivity.this,
                                "Operación de borrado cancelada!",Toast.LENGTH_SHORT).show();
                    }
                });

                ad.show();
                return true;
            }
        });

        fab_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AddPersonaActivity.class);
                i.putExtra("accion","a");
                i.putExtra("key","");
                i.putExtra("nombre","");
                i.putExtra("capital","");
                i.putExtra("idioma","");
                i.putExtra("moneda","");
                i.putExtra("información","");
                startActivity(i);
            }
        });

        pais = new ArrayList<>();

        consultaOrdenada.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pais.removeAll(pais);
                for (DataSnapshot dato : dataSnapshot.getChildren()) {
                    Pais Pais = dato.getValue(Pais.class);
                    Pais.setKey(dato.getKey());
                    pais.add(Pais);
                }

                AdaptadorPersona adapter = new AdaptadorPersona(PersonasActivity.this,
                        pais );
                listaPais.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}