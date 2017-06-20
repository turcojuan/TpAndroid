package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

/**
 * Created by jturco on 15/05/2017.
 */

public class ModelProductoMenu {

    private String nombre;
    private Double precio;
    private String imagen;
    private String tipoMenu;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public ModelProductoMenu()
    {}
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ModelProductoMenu(String nombre, Double precio)
    {
        this.nombre=nombre;
        this.precio=precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }
}
