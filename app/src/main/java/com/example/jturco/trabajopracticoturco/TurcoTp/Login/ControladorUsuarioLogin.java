package com.example.jturco.trabajopracticoturco.TurcoTp.Login;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jturco on 04/05/2017.
 */

public class ControladorUsuarioLogin {

    ListenerIngresar miListenerIng;
    String comprobacionLogin;
    MainActivity actividad;

    public ControladorUsuarioLogin(ListenerIngresar ing) {

        this.miListenerIng = ing;

    }

    public ListenerIngresar getMiListener() { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerIng;
    }

    public String validarUsuario(ModelUsuarioLogin usuarioIngresado) {


        if ((usuarioIngresado.getMail().toString().equals(MainActivity.mailValidoUser()) == true) && (usuarioIngresado.getPassword().toString().equals(MainActivity.passValidoUser()) == true)) {
            // Aca hay que agregarle un OR para que valide contra el mail y pass del array de ModelUserRegistrado, para ver si no esta cargado.
            return "Login Correcto";
        } else {
            return "Login Incorrecto";
        }
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
                comprobarLogin.setText(comprobacionLogin.toString());
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
        //Aca en lugar de ir a Registro tiene que ir al Menu de productos
        Intent in = new Intent(act,MainActivityRegistro.class);
        act.startActivity(in);
    }
    else {
        Log.d("No prefe","No prefe");}

    }

}

