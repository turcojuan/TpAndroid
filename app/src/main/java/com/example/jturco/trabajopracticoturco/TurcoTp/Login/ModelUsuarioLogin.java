package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

/**
 * Created by jturco on 04/05/2017.
 */

public class ModelUsuarioLogin {
    String mail;
    String password;
    String nombre;
    String apellido;
    Integer dni;


    public ModelUsuarioLogin() {}

    public ModelUsuarioLogin(String mail, String password)
    {
        this.mail= mail;
        this.password= password;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
