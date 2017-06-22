package com.example.jturco.trabajopracticoturco.TurcoTp.Login;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jturco on 04/05/2017.
 */

public class ControladorUsuarioLogin {

    ListenerIngresar miListenerIng;
    String comprobacionLogin;
    MainActivity actividad;
    private List<ModelUsuarioLogin> listaUsersFinal = new ArrayList<ModelUsuarioLogin>();
    public static String userLogueado;

    public ControladorUsuarioLogin(ListenerIngresar ing) {

        this.miListenerIng = ing;

    }

    public List<ModelUsuarioLogin> getListaUsersFinal() {
        return listaUsersFinal;
    }

    public void setListaUsersFinal(List<ModelUsuarioLogin> listaUsersFinal) {
        this.listaUsersFinal = listaUsersFinal;
    }

    public ListenerIngresar getMiListener() { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerIng;
    }

    public String validarUsuario(ModelUsuarioLogin usuarioIngresado) {
        String resultadoLogin= "Login Incorrecto"; //por defecto resultado incorrecto.

        ///if ((usuarioIngresado.getMail().toString().equals(MainActivity.mailValidoUser()) == true) && (usuarioIngresado.getPassword().toString().equals(MainActivity.passValidoUser()) == true)) {
            // Aca hay que agregarle un OR para que valide contra el mail y pass del array de ModelUserRegistrado, para ver si no esta cargado.


        //Hice esta lógica, pq en el postman siempre me tiraba error ir a buscar ip:3000/usuarios/mail.

        Log.d("userArrayLogica", listaUsersFinal.get(1).getMail());
       for(ModelUsuarioLogin uLogueado: listaUsersFinal)
       {
           if((usuarioIngresado.getMail().toString().equals(uLogueado.getMail()))&&(usuarioIngresado.getPassword().toString().equals(uLogueado.getPassword())))
           {
               Log.d("Ver.LoginApi",uLogueado.getMail());

               resultadoLogin= "Login Correcto";
               ControladorUsuarioLogin.userLogueado=usuarioIngresado.getMail().toString(); // lo asigno para usarlo en el post de la api
               break;
           }
       }
        return resultadoLogin;
    }

    public void ValidaLoginCargaUser(EditText editMail, EditText editPassword, CheckBox ckRecuerdame, Button comprobarLogin, VistaUsuarioLogin vistaLogin)
    {

        if ((editMail.getText().toString().isEmpty()) || (editPassword.getText().toString().isEmpty()))
                {
                    if (editMail.getText().toString().isEmpty())
                    {
                        editMail.setError("Ingrese mail");
                        if (editPassword.getText().toString().isEmpty())
                        {
                            editPassword.setError("Ingrese password"); } //para que te muestre el mensaje en pass sino ingresaste ninguno

                    } else if (editPassword.getText().toString().isEmpty())
                    {
                editPassword.setError("Ingrese password");
            }

            //si no está vacio y el mail tiene @ y . recien creo el user para validar.
        }else if ((editMail.getText().toString().contains("@"))&&(editMail.getText().toString().contains(".com"))){

            ModelUsuarioLogin usuario = new ModelUsuarioLogin(editMail.getText().toString(), editPassword.getText().toString());
            comprobacionLogin= (this.validarUsuario(usuario));

            if(comprobacionLogin.toString().equals("Login Correcto")== true)
            {
                if (ckRecuerdame.isChecked())
                {
                    //recien guardo cuando está OK los datos del login
                    vistaLogin.getActividad().guardarDatosUser(editMail.getText().toString(),editMail.getText().toString());
                }

                //Intent al menu de productos.
                //comprobarLogin.setText(comprobacionLogin.toString());
                Intent in = new Intent(vistaLogin.getActividad(),MainActivityMenuPedido.class);
                vistaLogin.getActividad().startActivity(in);

            }
            else
            {   //Mostrar dialogo

                vistaLogin.getActividad().mostrarDialogo();
                //comprobarLogin.setText(comprobacionLogin.toString());
            }
        }else
        {
            editMail.setError("Ingrese un mail correcto");  //else para el @ y .
        }
    }

    public void validarRecuerdame(MainActivity act){
        //Le paso la activity para que la logica quede aca, y esto se tiene que ejecutar desde el principio
    //Para validar el recuerdame
    //Si te tira el valor por defecto quiere decir que no se encontro nada en el SheredPrefer, si es distinto al valor por defecto que logue con los datos y cargados.
    if  ((!act.traerMailUserGuardado().equals("No encontro mail en preference")) && (!act.traerPassUserGuardado().equals("No encontro mail en preference")))
    {

        Log.d("Verificacion","Ok preferences");

       Intent in = new Intent(act,MainActivityMenuPedido.class);
       act.startActivity(in);
    }
    else {
        Log.d("No prefe","No prefe");}

    }

}

