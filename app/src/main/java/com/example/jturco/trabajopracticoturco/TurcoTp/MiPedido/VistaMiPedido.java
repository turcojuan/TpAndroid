package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jturco.trabajopracticoturco.R;

import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MiDialogoMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.VistaMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MiHiloAltaUser;

import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class VistaMiPedido implements IEnviarMiPedido,Handler.Callback {

    private MainActivityMiPedido actividad;
    private FloatingActionButton btnEnviarPedidoMiPedido;
    private ControladorMiPedido miControladorMiPedido;
    private String elementosSeleccionados;
    private String importeTotal;

    TextView tvImporteEstimadoMiPedido;
    //private List<ModelProductoMenu> listaMenuProdSel;

        //EN LA VISTA LE PASO EL ACTIVITY PARA IR A BUSCAR LOS IDS , EN EL CONSTRUCTOR
    //IMPLEMENTA LA INTERFACE QUE EJECUTA EL LISTENER.

    public void setMiControlador(ControladorMiPedido con) {
        this.miControladorMiPedido = con;
        btnEnviarPedidoMiPedido.setOnClickListener(miControladorMiPedido.getMiListenerEnviarMiPedido());

    }

    public VistaMiPedido(MainActivityMiPedido a) {
        this.actividad = a;
        btnEnviarPedidoMiPedido = (FloatingActionButton) actividad.findViewById(R.id.btnEnviarPedidoMiPedido);
        Button btnAgregar = (Button) actividad.findViewById(R.id.btnAgregarMenuPedido);
        tvImporteEstimadoMiPedido= (TextView) actividad.findViewById(R.id.tvImporteEstimadoMiPedido);
        //listaMenuProdSel= actividad.getListaMenuProdSel();

    }

    public TextView getTvImporteEstimadoMiPedido() {
        return tvImporteEstimadoMiPedido;
    }


    public void vaciarImporteEstimado()
    {
        tvImporteEstimadoMiPedido.setText("0.00");
        VistaMenuPedido.importeTotalMiPedido="0.00"; //Actualizo importe en Menu Pedido.
    }


    @Override
    public void mostrarPedidoSelecionado() {

        if (actividad.getListaMenuProdSel().size() != 0)
        {

            Log.d("MiPedido", "Se presiono en Enviar Pedido");
            Log.d("Elementos", String.valueOf(actividad.getListaMenuProdSel().size()));
        miControladorMiPedido.calcularImporteMiPedido(actividad.getListaMenuProdSel(),tvImporteEstimadoMiPedido);  //Llamo al controller

           //aca llamar ejecutar el Hilo
            //Handler
            Handler h1 = new Handler(this);
            Thread miHiloCargaPedido = new Thread(new MiHiloCargaPedido(h1,actividad.getListaMenuProdSel())); // le paso el user que creo con los datos validados desde la pantalla

            miHiloCargaPedido.start();


            //Esto ahora lo hago en Handler
        /*Toast toast0 = Toast.makeText(actividad, "El pedido fue enviado", Toast.LENGTH_SHORT);
        toast0.setGravity(Gravity.CENTER, 0, 400);
        toast0.show();


        String elementosSeleccionados = String.valueOf(actividad.getListaMenuProdSel().size());
        String importeTotal = tvImporteEstimadoMiPedido.getText().toString();
        Toast toast1 = Toast.makeText(actividad, "Total de item seleccionados: " + elementosSeleccionados + "\n" + "Importe Total: $" + importeTotal, Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.CENTER, 0, 450);
        toast1.show();*/
             elementosSeleccionados = String.valueOf(actividad.getListaMenuProdSel().size());
             importeTotal = tvImporteEstimadoMiPedido.getText().toString();
        actividad.getListaMenuProdSel().clear();
            //Limpio el static
            VistaMenuPedido.listaItemSeleccionados= null;
        Log.d("Elementos borrar", String.valueOf(actividad.getListaMenuProdSel().size()));

        Intent in = new Intent(actividad, MainActivityMenuPedido.class);
        actividad.startActivity(in);}
    else
    {//Mostrar Dialogo.
        this.actividad.mostrarDialogoSinItem();

    }

    }

    public void setImporteEstimado() {
           tvImporteEstimadoMiPedido.setText(miControladorMiPedido.calcularImporteMiPedido(actividad.getListaMenuProdSel(),tvImporteEstimadoMiPedido));
    }
    @Override
    public boolean handleMessage(Message message) {

        //Seteo la lista del controles que uso para validar el login
        String respuestPostMensaje=(String) message.obj;
        Log.d("RespuestaPostPedido",respuestPostMensaje.toString());

        if(respuestPostMensaje.contains("correctamente"))
        {
            Log.d("SeEnvioPedido",respuestPostMensaje.toString());
            Toast toast0 = Toast.makeText(actividad, "El pedido fue enviado", Toast.LENGTH_SHORT);
            toast0.setGravity(Gravity.CENTER, 0, 400);
            toast0.show();



            Toast toast1 = Toast.makeText(actividad, "Total de item seleccionados: " + elementosSeleccionados + "\n" + "Importe Total: $" + importeTotal, Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.CENTER, 0, 450);
            toast1.show();

        } else
        {
            Log.d("No se pudo enviar P","No se pudo enviar P");


        }


        return true;
    }

}


//Pase esta lógica al Controller.
   /* public String calcularImporteMiPedido()
    {String resultado=null;
        String valorActual= tvImporteEstimadoMiPedido.getText().toString();
        double importeActual= Double.parseDouble(valorActual);
        Log.d("Importe",tvImporteEstimadoMiPedido.getText().toString());
        for (ModelProductoMenu menuItem:actividad.getListaMenuProdSel())
        {
            double importe= menuItem.getPrecio();
            importeActual= importe + importeActual;

           // resultado = String.valueOf(sumaTotal);
        }
        resultado = String.valueOf(importeActual);
        return resultado;
        //tvImporteEstimadoMiPedido.setText(resultado);
    }

    public void restarImporte(ModelProductoMenu itemMenuProdSel)
    {String importeActual = tvImporteEstimadoMiPedido.getText().toString();

        double imp1 = Double.parseDouble(importeActual);
        double imp2 = Double.parseDouble(itemMenuProdSel.getPrecio().toString());
        double sumaTotal = imp1 - imp2;
        String resultado = String.valueOf(sumaTotal);
        tvImporteEstimadoMiPedido.setText(resultado);
    } */

