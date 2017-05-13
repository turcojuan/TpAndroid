package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

/**
 * Created by jturco on 09/05/2017.
 */

public class UserRegistrado{
    String nombre;
    String apellido;
    String dni;
    String mail;
    String clave;

    public String getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }

    public UserRegistrado(String nombre, String apellido, String dni, String mail, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.clave = clave;
    }

    @Override
    public boolean equals (Object o)
    {
        if(o instanceof UserRegistrado)
        {
            UserRegistrado u1 = (UserRegistrado) o;
            if(this.mail.equals(u1.getMail()) || (this.dni.equals(u1.getDni()))){

                return true;}
            else
                return false;
        }
        else
            return false;

    }
    @Override
    public int hashCode()
    {int numero= 31;
        int resultado= 1;

        if (dni != null)  // && nombre.equals(null) && apellido.equals(null))
        {
            resultado = numero * resultado + dni.hashCode();
        }
        if(nombre!=null) {
            resultado = numero * resultado + mail.hashCode();
        }
        return resultado;

    }

  }
