package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.view.View;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.IIngresar;

/**
 * Created by jturco on 05/05/2017.
 */

public class ListenerRegistar implements View.OnClickListener {

    IRegistrar ii;

    public ListenerRegistar( IRegistrar reg)
    {
        this.ii=reg;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistrarme) {
            ii.registarUsuario();
        }
    }
}
