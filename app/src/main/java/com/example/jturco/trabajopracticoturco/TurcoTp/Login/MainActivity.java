package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;

public class MainActivity extends AppCompatActivity {

    private static final String MAIL = "mail";
    private static final String PASSWORD = "pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ModelUsuarioLogin miModeloLogin= new ModelUsuarioLogin();
        VistaUsuarioLogin miVistaLogin = new VistaUsuarioLogin(this); //Le paso la instancia de la activity_main
        ControladorUsuarioLogin miControladorLogin = new ControladorUsuarioLogin((new ListenerIngresar(miVistaLogin))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaLogin.setMiControlador(miControladorLogin);

        //Para esconder la barra
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //para validar el recuerdame


           this.traerMailUserGuardado();
           this.traerPassUserGuardado();

        //Si te tira el valor por defecto quiere decir que no se encontro nada en el SheredPrefer, si es distinto al valor por defecto que logue con los datos y cargados.
        if  ((!this.traerMailUserGuardado().equals("No encontro mail en preference")) && (!this.traerPassUserGuardado().equals("No encontro mail en preference")))
        {
            Intent in = new Intent(this,MainActivityRegistro.class);
            this.startActivity(in);

        }

    }

        //Hago esto porque tiene que esta declarado aca y quiero que sea mediante clase
    public static String mailValidoUser() {
        String mailValido = "aaa@aaa.com";
        return mailValido;
    }

    public static String passValidoUser() {
        String passValida = "aaa123";
        return passValida;
    }


    public void guardarDatosUser(String mail, String pass)

    {SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE); // es clave valor

        miShPref.edit().putString(MAIL,mail);
        miShPref.edit().putString(PASSWORD,pass);
        miShPref.edit().commit();
}


    public String traerMailUserGuardado()
    {
        //para guardar los datos de ingreso, Recordar

        SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE); // es clave valor

        //para ir a recuperarlo.

        String mail = miShPref.getString(MAIL, "No encontro mail en preference");

        return mail;
    }

    public String traerPassUserGuardado()
    {
        SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE);

        String pass = miShPref.getString(PASSWORD, "No encontro pass en preference");

        return pass;
    }

}
