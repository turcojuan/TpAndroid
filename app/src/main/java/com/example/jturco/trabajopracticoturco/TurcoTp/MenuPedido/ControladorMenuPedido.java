package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ListenerIngresar;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.MainActivity;

import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class ControladorMenuPedido {

    ListenerEnviarPedido miListenerEnviarPedido;
    MainActivityMenuPedido actividadMenuPedido;

    public ControladorMenuPedido(ListenerEnviarPedido env) {

        this.miListenerEnviarPedido = env;

    }

    public ListenerEnviarPedido getMiListenerEnviarPedido()
    { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerEnviarPedido;
    }

    public String importeResultado(ModelProductoMenu itemMenuProd, TextView importe)
    {String precioActual = importe.getText().toString();
        String precioSelecionado =itemMenuProd.getPrecio().toString();
        double imp1 = Double.parseDouble(precioActual);
        double imp2 = Double.parseDouble(precioSelecionado);
        double sumaTotal = imp1 + imp2;
        String resultado = String.valueOf(sumaTotal);
    return resultado;}


    public String cantElementosSel (TextView elementosSel){
    String elementoSeleccionado = elementosSel.getText().toString();
    int elementosActuales = Integer.parseInt(elementoSeleccionado);
    int agregaUno = elementosActuales + 1;
    String acumulaElemento = String.valueOf(agregaUno);

    return acumulaElemento;
    }

}
