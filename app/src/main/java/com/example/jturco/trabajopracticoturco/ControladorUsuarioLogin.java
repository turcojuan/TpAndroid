package com.example.jturco.trabajopracticoturco;

/**
 * Created by jturco on 04/05/2017.
 */

public class ControladorUsuarioLogin {

    ListenerIngresar miListenerIng;

    public ControladorUsuarioLogin(ListenerIngresar ing){

        this.miListenerIng=ing;
    }

    public ListenerIngresar getMiListener(){ //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerIng;
    }

    public String validarUsuario(ModelUsuarioLogin usuarioIngresado)
    {
        String mailValido = "aaa@aaa.com";
        String passValida = "aaa123";
        //no puedo hacer que valide que el @ y numeros

        if((usuarioIngresado.getMail().toString().equals(mailValido)== true)&&(usuarioIngresado.getPassword().toString().equals(passValida)==true))
        { return "Login Correcto";}
        else
        {return "Login Incorrecto";}

    }

}
