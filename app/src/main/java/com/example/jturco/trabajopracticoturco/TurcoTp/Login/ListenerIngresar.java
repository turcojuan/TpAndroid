package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.content.Intent;
import android.view.View;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;

/**
 * Created by jturco on 04/05/2017.
 */

public class ListenerIngresar implements View.OnClickListener{

    IIngresar ii;

    public ListenerIngresar( IIngresar ing)
    {
        this.ii=ing;
    }

    public void onClick(View v)
    {
        if(v.getId()== R.id.btnIngresar)
        {
            ii.ingresarDatosLogin();
        }

        if(v.getId()== R.id.btnRegis)
        {
            ii.irPantallaRegistar();
        }
    }

}
