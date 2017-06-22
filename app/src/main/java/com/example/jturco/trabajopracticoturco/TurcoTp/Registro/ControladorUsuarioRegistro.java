package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ListenerIngresar;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.MiHiloUsuarios;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ModelUsuarioLogin;

import java.util.List;

/**
 * Created by jturco on 08/05/2017.
 */

public class ControladorUsuarioRegistro  implements Handler.Callback{

    ListenerRegistar miListenerReg;
    ModelUsuarioRegistro modelUser = new ModelUsuarioRegistro();
    VistaUsuarioRegistro vistaRegistro;


    public ControladorUsuarioRegistro(ListenerRegistar ing) {

        this.miListenerReg = ing;

    }

    public ListenerRegistar getMiListener() { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerReg;
    }

    public void ValidaRegistroUser(EditText nombre, EditText apellido, EditText dni, EditText mail, EditText password, EditText reingrese,VistaUsuarioRegistro vistaRegis) {
       this.vistaRegistro= vistaRegis;

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

                    //Aca tengo que ejecutar el hilo.

                    //Agregar un if si ya existe el mail o documento, segun mi array de Users.

                    //Handler
                    Handler h1 = new Handler(this);
                    Thread miHiloAltaUser = new Thread(new MiHiloAltaUser(h1,userRegis)); // le paso el user que creo con los datos validados desde la pantalla

                    miHiloAltaUser.start();

                    //Esto era parte de la validacion del primer parcial.

                  /*  if(modelUser.getListaUsersRegis().size()!=0)
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
                        vistaRegis.getActividad().finish();}*/

                } else {

                    password.setError("Las claves ingresadas no coinciden");
                    reingrese.setError("Las claves ingresadas no coinciden");
                }
            } else {
                mail.setError("Ingrese un mail valido");  //else para el @ y .
            //vistaRegis.getActividad().mostrarDialogo();
            }

    }

    @Override
    public boolean handleMessage(Message message) {

        //Seteo la lista del controles que uso para validar el login
        String respuestPostMensaje=(String) message.obj;
        Log.d("RespuestaPost",respuestPostMensaje.toString());

        if(respuestPostMensaje.contains("correctamente"))
        {
            Log.d("SeGeneroUser",respuestPostMensaje.toString());
            //mostrar mensaje
            Toast toast1 = Toast.makeText(vistaRegistro.getActividad(),"Se creo el usuario", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER,0,500);
            toast1.show();
            vistaRegistro.getActividad().finish();

        } else
        {
            Log.d("No se puedo crear User","No se puedo crear User");
            Toast toast1 = Toast.makeText(vistaRegistro.getActividad(),"No se puedo crear el usuario", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER,0,500);
            toast1.show();
            vistaRegistro.getActividad().finish();

        }


        return true;
    }


}


