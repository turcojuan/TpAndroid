package com.example.jturco.trabajopracticoturco;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String MAIL="mail";
    private static final String PASSWORD="pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ModelUsuarioLogin miModeloLogin= new ModelUsuarioLogin();
        VistaUsuarioLogin miVistaLogin = new VistaUsuarioLogin(this); //Le paso la instancia de la activity_main
        ControladorUsuarioLogin miControladorLogin = new ControladorUsuarioLogin((new ListenerIngresar(miVistaLogin))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaLogin.setMiControlador(miControladorLogin);

        //Para esconder la barra
        ActionBar actionBar= getSupportActionBar();
        actionBar.hide();

        //para guardar los datos de ingreso, Recordar

        SharedPreferences miShPref = getSharedPreferences("miConfig",MODE_PRIVATE); // es clave valor

        miShPref.edit().putString(MAIL,"mailIngresado");
        miShPref.edit().putString(PASSWORD,"passIngresada");
        //miShPref.edit().commit();
        miShPref.edit().apply(); // para guardar lo que editaste.
        //Pensa como hacer funcar con el btn Recordarme


        //para ir a recuperarlo.

        String b= miShPref.getString(MAIL,"No encontro mi str");


    }
}
