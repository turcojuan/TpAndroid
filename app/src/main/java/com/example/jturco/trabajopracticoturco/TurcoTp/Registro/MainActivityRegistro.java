package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jturco.trabajopracticoturco.R;

/**
 * Created by jturco on 05/05/2017.
 */

public class MainActivityRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ModelUsuarioRegistro miModeloRegistro= new ModelUsuarioRegistro();
        VistaUsuarioRegistro miVistaRegistro = new VistaUsuarioRegistro(this); //Le paso la instancia de la activity_main
        ControladorUsuarioRegistro miControladorRegistro = new ControladorUsuarioRegistro((new ListenerRegistar(miVistaRegistro))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaRegistro.setMiControlador(miControladorRegistro);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }

    public void mostrarDialogo()
    {MiDialogoRegistro dialog = new MiDialogoRegistro();
        dialog.show(getSupportFragmentManager(), "dialogo");}
}
