package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido.MainActivityMiPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;

import java.util.List;


/**
 * Created by jturco on 14/05/2017.
 */

public class VistaMenuPedido implements IEnviarPedido {
    public static List<ModelProductoMenu> listaItemSeleccionados;
    private MainActivityMenuPedido actividad;
    private FloatingActionButton btnEnviarPedido;
    private ControladorMenuPedido miControladorMenuPedido;
    TextView importe;
    TextView elementosSel;
    public static String importeTotalMiPedido;
   // private RecyclerView rv;

    public MainActivityMenuPedido getActividad() {
        return actividad;
    }

    //EN LA VISTA LE PASO EL ACTIVITY PARA IR A BUSCAR LOS IDS , EN EL CONSTRUCTOR
    //IMPLEMENTA LA INTERFACE QUE EJECUTA EL LISTENER.

    public void setMiControlador(ControladorMenuPedido con) {
        this.miControladorMenuPedido = con;
        btnEnviarPedido.setOnClickListener(miControladorMenuPedido.getMiListenerEnviarPedido());

    }

    public VistaMenuPedido(MainActivityMenuPedido a) {
        this.actividad = a;
        btnEnviarPedido = (FloatingActionButton) actividad.findViewById(R.id.btnEnviarPedidoMenuP);
        Button btnAgregar = (Button) actividad.findViewById(R.id.btnAgregarMenuPedido);
        importe= (TextView) actividad.findViewById(R.id.tvImporteEstimadoMenuP);
        elementosSel = (TextView) actividad.findViewById(R.id.tvElemSelecMenuP);
        //rv = (RecyclerView) this.actividad.findViewById(R.id.listMenuPedido);

    }
    public List<ModelProductoMenu> getListaMenuSel()
    {
        return actividad.getListaMenuProdSeleccionados();
    }

    //Insntacio rv
   /* public void instanciarRv() {
        //lo instancio y lo voy a buscar en el constructor.
        RecyclerView.LayoutManager layoutMang = new LinearLayoutManager(this.actividad);
        rv.setLayoutManager(layoutMang); // Como presenta la información
        Log.d("List", "Se esta por enviar");
        MyAdapterMenuPedido myAdapter = new MyAdapterMenuPedido(this.actividad.getListaMenuProd(), this.actividad); //"a" pq implemento IOnItem... y lo agregue en el constructor
        rv.setAdapter(myAdapter);
        rv.addItemDecoration(new DividerItemDecoration(this.actividad.getBaseContext(), 1));

    }*/

    @Override
    public void enviarPedidoMenuSelecionado() {

        if (actividad.getListaMenuProdSeleccionados().size() != 0) {
            //Enviar la listaDeMenuSeleccionado a la otra pantalla, mediante un metodo del controler.

            //Seteo el static aca, asi toma todos los cambios.
            listaItemSeleccionados=actividad.getListaMenuProdSeleccionados(); //Este atrib static lo llamo desde la otra Activity.

            Intent in = new Intent(actividad, MainActivityMiPedido.class);
            actividad.startActivity(in);


        } else {
            Log.d("Dialog", "Dialog no hay elemento selecionados");
                actividad.mostrarDialogo();

        }
    }
        //Llamar a metodo del Controler para importe que reciba el item desde activity

    public void calcularImporte(ModelProductoMenu itemMenuProd) {
        importe.setText(miControladorMenuPedido.importeResultado(itemMenuProd, importe));
        //hice esto para que le venga el item que se selecciono desde el main y que la logica se aplique desde el controller y el set text desde la vista.


    }

    public void calcularElementosSel() {
     //Llamar a metodo del controler para los elementos.
    elementosSel.setText(miControladorMenuPedido.cantElementosSel(elementosSel));
    }

}
