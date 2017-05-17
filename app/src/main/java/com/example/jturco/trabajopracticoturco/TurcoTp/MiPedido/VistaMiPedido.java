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
    TextView importe;
    TextView elementosSel;
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
        importe= (TextView) actividad.findViewById(R.id.tvImporteEstimadoMenuP);
        elementosSel = (TextView) actividad.findViewById(R.id.tvElemSelecMenuP);
        listaMenuProdSel= actividad.getListaMenuProdSel();

    }


    @Override
    public void mostrarPedidoSelecionado() {
        Log.d("MiPedido","Se presiono en Enviar Pedido");
    }
}
