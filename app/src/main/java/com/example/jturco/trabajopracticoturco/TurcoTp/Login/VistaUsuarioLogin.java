package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;

/**
 * Created by jturco on 04/05/2017.
 */

public class VistaUsuarioLogin implements IIngresar {

    private MainActivity actividad;
    private Button btnIngresar;
    private EditText editMail;
    private EditText editPassword;
    private ControladorUsuarioLogin miControladorLogin;
    private Button comprobarLogin;
    private Button btnRegistrar;
    private CheckBox chRecuerdame;

    public MainActivity getActividad() {
        return actividad;
    }

    //EN LA VISTA LE PASO EL ACTIVITY PARA IR A BUSCAR LOS IDS , EN EL CONSTRUCTOR
    //IMPLEMENTA LA INTERFACE QUE EJECUTA EL LISTENER.

    public void setMiControlador(ControladorUsuarioLogin con){
        this.miControladorLogin=con;
        btnIngresar.setOnClickListener(miControladorLogin.getMiListener());
        btnRegistrar.setOnClickListener(miControladorLogin.getMiListener());
    }

    public VistaUsuarioLogin(MainActivity a){
        this.actividad=a;
        btnIngresar = (Button) actividad.findViewById(R.id.btnIngresar);
        editMail= (EditText)  actividad.findViewById(R.id.editTextMail);
        editPassword=(EditText) actividad.findViewById(R.id.editTextPass);
        btnRegistrar= (Button) actividad.findViewById(R.id.btnRegis);
        chRecuerdame= (CheckBox) actividad.findViewById(R.id.checkRecordarme);


    }

    public Boolean getChRecuerdameEstado() {
        return chRecuerdame.isChecked();
    }

    @Override
    public void ingresarDatosLogin (){
        String comprobacionLogin;
        //esta bien que cree aca una instancia de modelo???. Osea tengo que asociar aca lo que se ingresa con el modelo?
        //Aca tendria que ir la logica (a llamar a algun metodo que valide) si el mail y pass estan en la "base"
        //Hago validacion para que no cree el user si no estan los datos.
        //La paso todos lo parametros para que la logica se haga en el controller

        miControladorLogin.ValidaLoginCargaUser(editMail,editPassword,chRecuerdame,comprobarLogin,this);
    }

    @Override
    public void irPantallaRegistar() {

        Intent in = new Intent(actividad,MainActivityRegistro.class);
        actividad.startActivity(in);
    }


    {

    }



}
