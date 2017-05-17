package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.IOnItemClickMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MyAdapterMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.VistaMenuPedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class MainActivityMiPedido extends AppCompatActivity implements IOnItemClickMiPedido {
    private List<ModelProductoMenu> listaMenuProdSel;
    MyAdapterMiPedido myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_pedido);

       /* ModelUsuarioRegistro miModeloRegistro= new ModelUsuarioRegistro();
        VistaUsuarioRegistro miVistaRegistro = new VistaUsuarioRegistro(this); //Le paso la instancia de la activity_main
        ControladorUsuarioRegistro miControladorRegistro = new ControladorUsuarioRegistro((new ListenerRegistar(miVistaRegistro))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaRegistro.setMiControlador(miControladorRegistro);*/

        MainActivityMenuPedido actMenuPedido = new MainActivityMenuPedido();
        this.listaMenuProdSel=actMenuPedido.getListaMenuProdSeleccionados(); // Aca tengo todos lo items selecionados en la anterior pantalla.



        //Log.d("La list cargada",listaMenuProdSeleccionados.get(0).getNombre());
        Log.d("La list cargada",String.valueOf(listaMenuProdSel.size()));
        RecyclerView rvMiPedido = (RecyclerView) this.findViewById(R.id.listMiPedido);
        RecyclerView.LayoutManager layoutMang = new LinearLayoutManager(this);
        rvMiPedido.setLayoutManager(layoutMang); // Como presenta la información
        myAdapter = new MyAdapterMiPedido(listaMenuProdSel,this); //this pq implemento IOnItem... y lo agregue en el constructor
        rvMiPedido.setAdapter(myAdapter);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_mis_pedidos)
    {

        getMenuInflater().inflate(R.menu.menu_mis_pedidos,menu_mis_pedidos);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.EnviarElPedidoActual) {
            Log.d("", "Click sobre la opcion EnviarElPedidoActual del menu_mis_pedidos");
        }
        if(item.getItemId() == R.id.LimpiarPedido) {
            Log.d("", "Click sobre la opcion LimpiarPedido del menu_mis_pedidos");
        }
        else if(item.getItemId() == R.id.CerrarSesionMisPedidos) {
            Log.d("", "Click sobre la opcion CerrarSesionMisPedidos del menu_mis_pedidos");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        //ACA ES DONDE SE EJECUTA CUANDO SE DA CLICK AL ITEM.

        Log.d("Se hizo click el item"+position,"RVlist");
        //miVistaMenuPedido.calcularImporte(listaMenuProd.get(position));
       // miVistaMenuPedido.calcularElementosSel();
        //Llamo a un metodo para agregar el item a una nueva lista
        this.eliminaItemSelecionadoMiPedido(listaMenuProdSel.get(position));
        myAdapter.notifyDataSetChanged();// para refrescar el rv
        Log.d("Agregoooo a:",listaMenuProdSel.get(position).getNombre().toString());

    }

    public void eliminaItemSelecionadoMiPedido(ModelProductoMenu itemMenuProdSel)
    {
        listaMenuProdSel.remove(itemMenuProdSel);

    }
}
