package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jturco on 05/05/2017.
 */

public class ModelUsuarioRegistro {

    List<UserRegistrado> listaUsersRegis= new ArrayList<>();


    public ModelUsuarioRegistro()
        {   //hago esto para ver que muestre el Dialogo que no se genero el user.
            UserRegistrado ur=new UserRegistrado("a","a","dni","a@a.com","aa");
            this.listaUsersRegis.add(ur);
            Log.d("UserParaVerificar","UserParaVerificar");


        }

    public List<UserRegistrado> getListaUsersRegis() {
        return listaUsersRegis;
    }

}
