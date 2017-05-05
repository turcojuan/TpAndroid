package com.example.jturco.trabajopracticoturco;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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
    private  Button btnRegistrar;
    private CheckBox chRecuerdame;

    //EN LA VISTA LE PASo EL ACTIVITY PARA IR A BUSCAR LOS IDS , EN EL CONSTRUCTOR
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
        comprobarLogin= (Button) actividad.findViewById(R.id.btnComprobacionLogin);
    }


    @Override
    public void ingresarDatosLogin (){

        //esta bien que cree aca una instancia de modelo???. Osea tengo que asociar aca lo que se ingresa con el modelo?
        //Aca tendria que ir la logica (a llamar a algun metodo que valide) si el mail y pass estan en la "base"


        //Hago validacion para que no cree el user si no estan los datos.


        if ((editMail.getText().toString().isEmpty()) || (editPassword.getText().toString().isEmpty()))
        {
            if (editMail.getText().toString().isEmpty())
            {
                editMail.setError("Ingrese mail");

            } else if (editPassword.getText().toString().isEmpty())
            {
                editPassword.setError("Ingrese password");
            }

            //si no está vacio y el mail tiene @ y . recien creo el user para validar.
        }else if (editMail.getText().toString().contains("@")||(editMail.getText().toString().contains(".com"))){
            ModelUsuarioLogin usuario = new ModelUsuarioLogin(editMail.getText().toString(), editPassword.getText().toString());
            comprobarLogin.setText(miControladorLogin.validarUsuario(usuario)); // Voy a llamar al metodo del controller.
        }else
        {
            editMail.setError("Ingrese un mail correcto");
        }
    }

    @Override
    public void irPantallaRegistar() { // Tengo que hacer un listener distinto para hacer esto??.

        // esto lo hice para ver si funciona, aca tiene que ir a llamar a la pantalla de registación.
        btnIngresar.setText("Se hizo click en Registrar");
    }
}
