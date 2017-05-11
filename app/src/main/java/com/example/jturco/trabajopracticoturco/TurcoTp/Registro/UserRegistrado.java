package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

/**
 * Created by jturco on 09/05/2017.
 */

public class UserRegistrado {
    String nombre;
    String apellido;
    String dni;
    String mail;
    String clave;


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
            if(this.nombre.equals(u1.nombre) && (this.apellido.equals(u1.apellido) && (this.dni == u1.dni))){

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
        if(nombre!=null)
            resultado = numero * resultado + nombre.hashCode();


        if (apellido != null)
        {
            resultado = numero * resultado + apellido.hashCode();
            return resultado;
        }

        return resultado;

    }
}
