package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ControladorUsuarioRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ListenerRegistar;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ModelUsuarioRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.VistaUsuarioRegistro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class MainActivityMenuPedido extends AppCompatActivity implements IOnItemClickMenuPedido {
  private  List<ModelProductoMenu> listaMenuProd;
  private  List<ModelProductoMenu> listaMenuProdSeleccionados =new ArrayList<ModelProductoMenu>();
  private  VistaMenuPedido miVistaMenuPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pedido);

        miVistaMenuPedido = new VistaMenuPedido(this);
        ControladorMenuPedido miControladorMenuPedido = new ControladorMenuPedido((new ListenerEnviarPedido(miVistaMenuPedido))); // le pasas mi vista porque implementa IEnviarPedido
        miVistaMenuPedido.setMiControlador(miControladorMenuPedido);


      RecyclerView rv = (RecyclerView) this.findViewById(R.id.listMenuPedido);

        listaMenuProd = new ArrayList<ModelProductoMenu>();
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));
        listaMenuProd.add(new ModelProductoMenu("Pizza",60.00));

        RecyclerView.LayoutManager layoutMang = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutMang); // Como presenta la información
        MyAdapterMenuPedido myAdapter = new MyAdapterMenuPedido(listaMenuProd,this); //this pq implemento IOnItem... y lo agregue en el constructor
        rv.setAdapter(myAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu_pedidos)
    {

        getMenuInflater().inflate(R.menu.menu_pedidos,menu_pedidos);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.verPedidoActual) {
            Log.d("", "Click sobre la verPedidoActual1 del menu_pedidos");
        }
        if(item.getItemId() == R.id.CerrarSesionPedidos) {
            Log.d("", "Click sobre la opcion CerrarSesionPedidos del menu_pedidos");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
            //ACA ES DONDE SE EJECUTA CUANDO SE DA CLICK AL ITEM.
        //Llamar aca a un metodo de vista para que set a Importe el valor del item seleccionado

        //Esto quizas tenga que manejarlo entre la vista y el controller.

        Log.d("Se hizo click el item"+position,"RVlist");
        miVistaMenuPedido.calcularImporte(listaMenuProd.get(position));
        miVistaMenuPedido.calcularElementosSel();
        //Llamo a un metodo para agregar el item a una nueva lista
            this.agregaItemSelecionadoMiPedido(listaMenuProd.get(position));
            Log.d("Agregoooo a:",listaMenuProd.get(position).getNombre().toString());

    }

    public List<ModelProductoMenu> getListaMenuProdSeleccionados() {
        return listaMenuProdSeleccionados;
    }

    public void agregaItemSelecionadoMiPedido(ModelProductoMenu itemMenuProdSel)
    {
           listaMenuProdSeleccionados.add(itemMenuProdSel);

    }
}
