package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jturco on 05/05/2017.
 */

public class ModelUsuarioRegistro {

    List<UserRegistrado> listaUsersRegis= new ArrayList<>();
    UserRegistrado user;

    public ModelUsuarioRegistro()
        {

        }

    public List<UserRegistrado> getListaUsersRegis() {
        return listaUsersRegis;
    }

}
