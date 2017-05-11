package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
        //Si te tira el valor por defecto quiere decir que no se encontro nada en el SheredPrefer, si es distinto al valor por defecto que logue con los datos y cargados.
        if  ((!this.traerMailUserGuardado().equals("No encontro mail en preference")) && (!this.traerPassUserGuardado().equals("No encontro mail en preference")))
        {

            Log.d("Verificacion","Ok preferences");
            // Intent in = new Intent(this,MainActivityRegistro.class);
            //this.startActivity(in);

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

        SharedPreferences.Editor editor = miShPref.edit();


        editor.putString(MAIL,mail);
        editor.putString(PASSWORD,pass);
        editor.commit();
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

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;

    }
    //ya tienen su listener creado, no hacer falta crear uno nuevo

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            Log.d("", "Click sobre la opcion 1 del menu");
        }
        if(item.getItemId() == R.id.item2) {
            Log.d("", "Click sobre la opcion 2 del menu");
        }

        return super.onOptionsItemSelected(item);
    }*/

}
