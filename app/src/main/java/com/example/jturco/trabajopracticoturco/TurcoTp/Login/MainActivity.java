package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MiDialogoRegistro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private static final String MAIL = "mail";
    private static final String PASSWORD = "pass";
    ControladorUsuarioLogin miControladorLogin;
    public static String ipApi="http://192.168.1.36:3000"; //Creo esto para no ir cambiando en todos los hilos.


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ModelUsuarioLogin miModeloLogin= new ModelUsuarioLogin();
        VistaUsuarioLogin miVistaLogin = new VistaUsuarioLogin(this); //Le paso la instancia de la activity_main
        miControladorLogin = new ControladorUsuarioLogin((new ListenerIngresar(miVistaLogin))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaLogin.setMiControlador(miControladorLogin);

        //Para esconder la barra
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //Llamar a verificar si estan las referencias (Hacer esta logica en el controler).
        miControladorLogin.validarRecuerdame(this);
        //Handler
        Handler h = new Handler(this);
        Thread miHiloUsuarios = new Thread(new MiHiloUsuarios(h));

        miHiloUsuarios.start();

    }


    //Comento validacion login del primer parcial
 /*   //Hago esto porque tiene que esta declarado aca y quiero que sea mediante clase
    public static String mailValidoUser() {
        String mailValido = "aaa@aaa.com";
        return mailValido;
    }

    public static String passValidoUser() {
        String passValida = "aaa123";
        return passValida;
    }
*/

    public void guardarDatosUser(String mail, String pass)

    {
        SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE); // es clave valor

        SharedPreferences.Editor editor = miShPref.edit();


        editor.putString(MAIL, mail);
        editor.putString(PASSWORD, pass);
        editor.commit();
    }


    public String traerMailUserGuardado() {
        //para guardar los datos de ingreso, Recordar

        SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE); // es clave valor

        //para ir a recuperarlo.

        String mail = miShPref.getString(MAIL, "No encontro mail en preference");

        return mail;
    }

    public String traerPassUserGuardado() {
        SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE);

        String pass = miShPref.getString(PASSWORD, "No encontro pass en preference");

        return pass;
    }

    public void mostrarDialogo() {
        MiDialogoLogin dialog = new MiDialogoLogin();
        dialog.show(getSupportFragmentManager(), "dialogoLogin");
    }


    @Override
    public boolean handleMessage(Message message) {

        //Seteo la lista del controles que uso para validar el login
       miControladorLogin.setListaUsersFinal((List<ModelUsuarioLogin>) message.obj);

        Log.d("Llego mi mail", "Llego mi mail");
        Log.d("ListaUsers",miControladorLogin.getListaUsersFinal().get(0).getNombre());
        Log.d("ListaUsers",miControladorLogin.getListaUsersFinal().get(0).getPassword());
        //Log.d("ListaUsers",miControladorLogin.getListaUsersFinal().get(1).getMail());

        //String mail=null;
            //aca tengo que agregar a la lista de users.
           // Log.d("ListaUsers",listaUsers.get(1).getNombre());
       // mail= (String) message.obj;

        return true;
    }

}


