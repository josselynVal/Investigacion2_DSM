package com.edu.sv.ejercicio.informacion;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.edu.sv.ejercicio.R;
import com.edu.sv.ejercicio.datos.Pais;

import java.util.List;

public class AdaptadorPersona extends ArrayAdapter<Pais> {

    List<Pais> pais;
    private Activity context;

    public AdaptadorPersona(@NonNull Activity context, @NonNull List<Pais> pais) {
        super(context, R.layout.activity_adaptador_persona, pais);
        this.context = context;
        this.pais = pais;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowview=null;

        if (view == null)
            rowview = layoutInflater.inflate(R.layout.activity_adaptador_persona,null);
        else rowview = view;

        TextView tvNombre = rowview.findViewById(R.id.tvNombre);
        TextView tvCapital = rowview.findViewById(R.id.tvCapital);
        TextView tvIdioma = rowview.findViewById(R.id.tvIdioma);
        TextView tvMoneda = rowview.findViewById(R.id.tvMoneda);
        TextView tvInfor = rowview.findViewById(R.id.tvInfor);

        tvNombre.setText("Nombre : "+pais.get(position).getNombre());
        tvCapital.setText("Capital : " + pais.get(position).getCapital());
        tvIdioma.setText("Idioma : " + pais.get(position).getIdioma());
        tvMoneda.setText("Moneda : " + pais.get(position).getMoneda());
        tvInfor.setText("Información : " + pais.get(position).getInf());

        return rowview;
    }
}