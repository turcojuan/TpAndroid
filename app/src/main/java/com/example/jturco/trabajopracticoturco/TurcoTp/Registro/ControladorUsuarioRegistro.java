package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ListenerIngresar;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ModelUsuarioLogin;

/**
 * Created by jturco on 08/05/2017.
 */

public class ControladorUsuarioRegistro {

    ListenerRegistar miListenerReg;
    ModelUsuarioRegistro modelUser = new ModelUsuarioRegistro();


    public ControladorUsuarioRegistro(ListenerRegistar ing) {

        this.miListenerReg = ing;

    }

    public ListenerRegistar getMiListener() { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerReg;
    }

    public void ValidaRegistroUser(EditText nombre, EditText apellido, EditText dni, EditText mail, EditText password, EditText reingrese,VistaUsuarioRegistro vistaRegis) {
        if ((nombre.getText().toString().isEmpty()) || (apellido.getText().toString().isEmpty()) || (dni.getText().toString().isEmpty()) || (mail.getText().toString().isEmpty()) || (password.getText().toString().isEmpty()) || (reingrese.getText().toString().isEmpty())) {
           //Mostrar Toast
            vistaRegis.mostrarMensajeAlUsuario();
            Log.d("Log1","Log1");
            //si no está vacio y el mail tiene @ y . recien creo el user para validar.
        } else if (mail.getText().toString().contains("@") && mail.getText().toString().contains(".com")) {
                Log.d("Log2", "Log2");
                if (password.getText().toString().equals(reingrese.getText().toString())) {
                    Log.d("Log3", "Log3");

                    UserRegistrado userRegis = new UserRegistrado(nombre.getText().toString(),apellido.getText().toString(),dni.getText().toString(),mail.getText().toString(),password.getText().toString());

                    Log.d("se creo user", "se creo user");

                    if(modelUser.getListaUsersRegis().size()!=0)
                    {
                        Log.d("Tiene elementos", modelUser.getListaUsersRegis().get(0).dni);

                        //for(int i=0; i<modelUser.getListaUsersRegis().size(); i++)
                          for(UserRegistrado userExistente : modelUser.getListaUsersRegis())
                        {
                           // Log.d("DniExistente",userExistente.dni);
                           // Log.d("DniCargado",userRegis.dni);
                            if(userRegis.equals(userExistente))
                            {
                                Log.d("Ya existe el user","Ya existe el user");
                                vistaRegis.getActividad().mostrarDialogo();
                                break;
                            }
                             else if(!userRegis.equals(userExistente)) {
                            modelUser.getListaUsersRegis().add(userRegis);
                            Log.d("Se genero user OK", "Se genero user OK");
                                vistaRegis.getActividad().finish(); //Para ir al login
                            break;}
                        }
                    } else if(modelUser.getListaUsersRegis().size()==0)
                    {
                        modelUser.getListaUsersRegis().add(userRegis);
                        Log.d("Se genero user OK2", "Se genero user OK2");
                        vistaRegis.getActividad().finish();}

                } else {

                    password.setError("Las claves ingresadas no coinciden");
                    reingrese.setError("Las claves ingresadas no coinciden");
                }
            } else {
                mail.setError("Ingrese un mail valido");  //else para el @ y .
            //vistaRegis.getActividad().mostrarDialogo();
            }

    }
}


