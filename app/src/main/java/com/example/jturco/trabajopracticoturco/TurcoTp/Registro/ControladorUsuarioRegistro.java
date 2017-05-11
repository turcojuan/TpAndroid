package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

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

    public void ValidaRegistroUser(MainActivityRegistro vista,EditText nombre, EditText apellido, EditText dni, EditText mail, EditText password, EditText reingrese) {
        if ((nombre.getText().toString().isEmpty()) || (apellido.getText().toString().isEmpty()) || (dni.getText().toString().isEmpty()) || (mail.getText().toString().isEmpty()) || (password.getText().toString().isEmpty()) || (reingrese.getText().toString().isEmpty())) {
           // vista.mostrarMensajeAlUsuario();
            Log.d("Log1","Log1");
            //si no está vacio y el mail tiene @ y . recien creo el user para validar.
        } else if (mail.getText().toString().contains("@") && mail.getText().toString().contains(".com")) {
                Log.d("Log2", "Log2");
                if (password.getText().toString().equals(reingrese.getText().toString())) {
                    //registrarme.setText("Correcto");
                    Log.d("Log3", "Log3");
                    //Aca crear el array si no esta (Singleton?) (sino existe el array lo creo), sino agregar un nuevo elemento.

                    UserRegistrado userRegis = new UserRegistrado(nombre.toString(),apellido.toString(),dni.toString(),mail.toString(),password.toString());
                    Log.d("se creo user", "se creo user");

                    if(modelUser.listaUsersRegis.size()!=0)
                    {

                        for (UserRegistrado userExistente : modelUser.listaUsersRegis) {
                            if (userRegis.equals(userExistente) == false) {
                                modelUser.listaUsersRegis.add(userRegis);
                                Log.d("Se genero user OK", "Se genero user OK");
                                vista.finish(); //Para ir al login
                                //break;
                            } else {//Dialogo el user ya existe
                                Log.d("Ya existe el user", "Ya existe el user");
                                //break;
                            }
                        }
                    } else
                        modelUser.listaUsersRegis.add(userRegis);
                        Log.d("Se genero user OK", "Se genero user OK");
                        vista.finish();

                    {
                    }

                } else {

                    password.setError("Las claves ingresadas no coinciden");
                    reingrese.setError("Las claves ingresadas no coinciden");
                }
            } else {
                mail.setError("Ingrese un mail valido");  //else para el @ y .
            }

    }
}


