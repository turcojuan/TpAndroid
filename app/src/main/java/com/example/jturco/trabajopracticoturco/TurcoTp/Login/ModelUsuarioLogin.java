package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

/**
 * Created by jturco on 04/05/2017.
 */

public class ModelUsuarioLogin {
    String mail;
    String password;

    public ModelUsuarioLogin(String mail, String password)
    {
        this.mail= mail;
        this.password= password;

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
