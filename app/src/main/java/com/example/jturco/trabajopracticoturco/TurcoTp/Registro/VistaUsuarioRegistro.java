package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ControladorUsuarioLogin;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.MainActivity;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ModelUsuarioLogin;

/**
 * Created by jturco on 05/05/2017.
 */

public class VistaUsuarioRegistro implements IRegistrar {

    private MainActivityRegistro actividad;
    private EditText editNombre;
    private EditText editApellido;
    private EditText editDNI;
    private EditText editMail;
    private EditText editPassword;
    private EditText editReingrese;
    private  Button btnRegistrarmeRegis;
    private ControladorUsuarioRegistro miControladorRegistro;

    public EditText getEditNombre() {return editNombre;}

    public EditText getEditApellido() {return editApellido;}

    public EditText getEditDNI() {return editDNI;}

    public EditText getEditMail() {return editMail;}

    public EditText getEditPassword(){return editPassword; }

    public EditText getEditReingrese() {return editReingrese; }


    public void setMiControlador(ControladorUsuarioRegistro con){
        this.miControladorRegistro=con;
        btnRegistrarmeRegis.setOnClickListener(miControladorRegistro.getMiListener());
    }

    public VistaUsuarioRegistro(MainActivityRegistro a){
        this.actividad=a;

        editNombre= (EditText)  actividad.findViewById(R.id.editTextNombreRegis);
        editApellido= (EditText)  actividad.findViewById(R.id.editTextApeRegis);
        editDNI= (EditText)  actividad.findViewById(R.id.editTextDNIRegis);
        editNombre= (EditText)  actividad.findViewById(R.id.editTextNombreRegis);
        editMail= (EditText)  actividad.findViewById(R.id.editTextMailRegis);
        editPassword=(EditText) actividad.findViewById(R.id.editTextClaveRegis);
        editReingrese=(EditText) actividad.findViewById(R.id.editTextReingresoRegis);
        btnRegistrarmeRegis= (Button) actividad.findViewById(R.id.btnRegistrarme);


    }
    @Override
    public void registarUsuario() {


        //Aca tengo que ir a validar los datos y si agregar el user a los modelos
        //Queda bien si hago un Get para pasar todos los campos al controller?.

        miControladorRegistro.ValidaRegistroUser(actividad,editNombre,editApellido,editDNI,editMail,editPassword,editReingrese);
    }


    // para indicar que faltan ingresar campos
    public void mostrarMensajeAlUsuario(){
        Toast toast1 = Toast.makeText(this.actividad,"Deber complemetar todos los campos", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER,0,500);
        toast1.show();
    }
}
