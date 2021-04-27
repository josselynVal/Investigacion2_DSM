package com.edu.sv.ejercicio.informacion;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.edu.sv.ejercicio.R;
import com.edu.sv.ejercicio.datos.Pais;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtNombre, edtCapital, edtIdioma, edtMoneda,edtInf;
    String key="",nombre="",capital="",idioma="",moneda="", inf="", accion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtCapital = findViewById(R.id.edtCapital);
        edtIdioma = findViewById(R.id.edtIdioma);
        edtMoneda = findViewById(R.id.edtMoneda);
        edtInf = findViewById(R.id.edtInfor);

        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        nombre=datos.getString("nombre");
        capital = datos.getString("capital");
        idioma = datos.getString("idioma");
        moneda = datos.getString("moneda");
        inf = datos.getString("información");

        accion=datos.getString("accion");
        edtNombre.setText(nombre);
        edtCapital.setText(capital);
        edtIdioma.setText(idioma);
        edtMoneda.setText(moneda);
        edtInf.setText(inf);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String capital = edtCapital.getText().toString();
        String idioma = edtIdioma.getText().toString();
        String moneda = edtMoneda.getText().toString();
        String inf = edtInf.getText().toString();

        Pais pais = new Pais( nombre, capital, idioma, moneda, inf);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPais.push().setValue(pais);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPais.child(key).setValue(pais);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}