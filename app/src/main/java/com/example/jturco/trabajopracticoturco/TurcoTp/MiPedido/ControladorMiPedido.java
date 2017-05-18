package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.util.Log;
import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ListenerEnviarPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;

import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class ControladorMiPedido {


    ListenerEnviarMiPedido miListenerEnviarMiPedido;
    MainActivityMiPedido actividadMiPedido;

    public ControladorMiPedido(ListenerEnviarMiPedido env) {

        this.miListenerEnviarMiPedido = env;

    }

    public ListenerEnviarMiPedido getMiListenerEnviarMiPedido()
    { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerEnviarMiPedido;
    }

    public String calcularImporteMiPedido(List<ModelProductoMenu> listaMenuProdSel, TextView tvImporteEstimadoMiPedido)
    {String resultado=null;
        String valorActual= tvImporteEstimadoMiPedido.getText().toString();
        double importeActual= Double.parseDouble(valorActual);
        Log.d("Importe",tvImporteEstimadoMiPedido.getText().toString());
        for (ModelProductoMenu menuItem:listaMenuProdSel)
        {
            double importe= menuItem.getPrecio();
            importeActual= importe + importeActual;

            // resultado = String.valueOf(sumaTotal);
        }
        resultado = String.valueOf(importeActual);
        return resultado;
        //tvImporteEstimadoMiPedido.setText(resultado);
    }

    public void restarImporte(ModelProductoMenu itemMenuProdSel, TextView tvImporteEstimadoMiPedido)
    {String importeActual = tvImporteEstimadoMiPedido.getText().toString();

        double imp1 = Double.parseDouble(importeActual);
        double imp2 = Double.parseDouble(itemMenuProdSel.getPrecio().toString());
        double sumaTotal = imp1 - imp2;
        String resultado = String.valueOf(sumaTotal);
        tvImporteEstimadoMiPedido.setText(resultado);
    }

}
