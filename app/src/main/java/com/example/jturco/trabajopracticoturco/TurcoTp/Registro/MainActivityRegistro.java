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

        //ModelUsuarioLogin miModeloLogin= new ModelUsuarioLogin();
        //VistaUsuarioLogin miVistaLogin = new VistaUsuarioLogin(this); //Le paso la instancia de la activity_main
        //ControladorUsuarioLogin miControladorLogin = new ControladorUsuarioLogin((new ListenerIngresar(miVistaLogin))); // le pasas mi vista porque implementa IMostrarResultado
        //miVistaLogin.setMiControlador(miControladorLogin);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
