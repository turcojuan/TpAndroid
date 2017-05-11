package com.example.jturco.trabajopracticoturco.TurcoTp.Login;


import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by jturco on 04/05/2017.
 */

public class ControladorUsuarioLogin {

    ListenerIngresar miListenerIng;
    String comprobacionLogin;

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

    public void ValidaLoginCargaUser(EditText editMail, EditText editPassword, CheckBox ckRecuerdame, Button comprobarLogin, MainActivity act)
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
                    act.guardarDatosUser(editMail.getText().toString(),editMail.getText().toString());
                }


                comprobarLogin.setText(comprobacionLogin.toString());
            }
            else
            {comprobarLogin.setText(comprobacionLogin.toString());}//Mostrar dialogo
        }else
        {
            editMail.setError("Ingrese un mail correcto");  //else para el @ y .
        }
    }


}

