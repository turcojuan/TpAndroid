package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.R;

import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;

import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class VistaMiPedido implements IEnviarMiPedido {

    private MainActivityMiPedido actividad;
    private Button btnEnviarPedidoMiPedido;
    private ControladorMiPedido miControladorMiPedido;
    TextView tvImporteEstimadoMiPedido;
    private List<ModelProductoMenu> listaMenuProdSel;

        //EN LA VISTA LE PASO EL ACTIVITY PARA IR A BUSCAR LOS IDS , EN EL CONSTRUCTOR
    //IMPLEMENTA LA INTERFACE QUE EJECUTA EL LISTENER.

    public void setMiControlador(ControladorMiPedido con) {
        this.miControladorMiPedido = con;
        btnEnviarPedidoMiPedido.setOnClickListener(miControladorMiPedido.getMiListenerEnviarMiPedido());

    }

    public VistaMiPedido(MainActivityMiPedido a) {
        this.actividad = a;
        btnEnviarPedidoMiPedido = (Button) actividad.findViewById(R.id.btnEnviarPedidoMiPedido);
        Button btnAgregar = (Button) actividad.findViewById(R.id.btnAgregarMenuPedido);
        tvImporteEstimadoMiPedido= (TextView) actividad.findViewById(R.id.tvImporteEstimadoMiPedido);
        listaMenuProdSel= actividad.getListaMenuProdSel();

    }
    public void vaciarImporteEstimado()
    {
        tvImporteEstimadoMiPedido.setText("0.00");
    }


    @Override
    public void mostrarPedidoSelecionado() {
        Log.d("MiPedido","Se presiono en Enviar Pedido")
        //Mostrar Dialogo.
        ;
    }

    public void setImporteEstimado() {
           tvImporteEstimadoMiPedido.setText(this.calcularImporteMiPedido());
    }


    public String calcularImporteMiPedido()
    {String resultado=null;
        String valorActual= tvImporteEstimadoMiPedido.getText().toString();
        double importeActual= Double.parseDouble(valorActual);
        Log.d("Importe",tvImporteEstimadoMiPedido.getText().toString());
        for (ModelProductoMenu menuItem:this.listaMenuProdSel)
        {
            double importe= menuItem.getPrecio();
            importeActual= importe + importeActual;

           // resultado = String.valueOf(sumaTotal);
        }
        resultado = String.valueOf(importeActual);
        return resultado;
        //tvImporteEstimadoMiPedido.setText(resultado);
    }

    }
