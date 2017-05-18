package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ControladorMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.IOnItemClickMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MiDialogoMenuPedido;
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
    VistaMiPedido miVistaMiPedido;
    ControladorMiPedido miControladorMiPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_pedido);
          /*   MainActivityMenuPedido actMenuPedido = new MainActivityMenuPedido();
        this.listaMenuProdSel=actMenuPedido.getListaMenuProdSeleccionados(); // Aca tengo todos lo items selecionados en la anterior pantalla.
        */
        this.listaMenuProdSel=VistaMenuPedido.listaItemSeleccionados;
        Log.d("STATICtest",String.valueOf(listaMenuProdSel.size()));
        Log.d("STATICtest1",this.listaMenuProdSel.get(0).getNombre());


       /* //Hago esto para probar.
        this.listaMenuProdSel= new ArrayList<ModelProductoMenu>();
        this.listaMenuProdSel.add(new ModelProductoMenu("Menu Juan",100.00));
        this.listaMenuProdSel.add(new ModelProductoMenu("Menu test",200.00)); */

        miVistaMiPedido= new VistaMiPedido(this); //Le paso la instancia de la activity_main
        miControladorMiPedido = new ControladorMiPedido((new ListenerEnviarMiPedido(miVistaMiPedido))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaMiPedido.setMiControlador(miControladorMiPedido);
        miVistaMiPedido.setImporteEstimado();




        //Log.d("La list cargada",listaMenuProdSeleccionados.get(0).getNombre());
        //Log.d("La list cargada",String.valueOf(listaMenuProdSel.size()));
        RecyclerView rvMiPedido = (RecyclerView) this.findViewById(R.id.listMiPedido);
        RecyclerView.LayoutManager layoutMang = new LinearLayoutManager(this);
        rvMiPedido.setLayoutManager(layoutMang); // Como presenta la información
        myAdapter = new MyAdapterMiPedido(listaMenuProdSel,this); //this pq implemento IOnItem... y lo agregue en el constructor
        rvMiPedido.setAdapter(myAdapter);
        rvMiPedido.addItemDecoration(new DividerItemDecoration(this.getBaseContext(),1));

        }

    public List<ModelProductoMenu> getListaMenuProdSel() {
        return this.listaMenuProdSel;
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
            miVistaMiPedido.mostrarPedidoSelecionado();

        }
        if(item.getItemId() == R.id.LimpiarPedido) {
            listaMenuProdSel.clear();
            myAdapter.notifyDataSetChanged(); // para refrescar.
            miVistaMiPedido.vaciarImporteEstimado();
        }
        else if(item.getItemId() == R.id.CerrarSesionMisPedidos) {
            this.finish();


            //Borrar los datos de preference
            //pasar al intent del login y hacerle finish().
            SharedPreferences miShPref = getSharedPreferences("miConfig", MODE_PRIVATE); // es clave valor

            SharedPreferences.Editor editor = miShPref.edit();
            editor.clear(); // limpio las preferences
            editor.commit();
            Log.d("Borro Prefe","Borro Prefe");

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position) {
        //ACA ES DONDE SE EJECUTA CUANDO SE DA CLICK AL ITEM.

        Log.d("Se hizo click el item"+position,"RVlist");

        //Tengo que hacer algo para que reste cada elemento que se elimina.
        miControladorMiPedido.restarImporte(listaMenuProdSel.get(position),miVistaMiPedido.getTvImporteEstimadoMiPedido());
        Log.d("Elimino a:",listaMenuProdSel.get(position).getNombre().toString());
        this.eliminaItemSelecionadoMiPedido(listaMenuProdSel.get(position));
        myAdapter.notifyDataSetChanged();// para refrescar el rv
    }


   //esto pasarlo a la vista
    public void eliminaItemSelecionadoMiPedido(ModelProductoMenu itemMenuProdSel)
    {
        this.listaMenuProdSel.remove(itemMenuProdSel);

    }

    public void mostrarDialogoSinItem()
    {MiDialogoMenuPedido dialog = new MiDialogoMenuPedido();
        dialog.show(getSupportFragmentManager(), "dialogoMenuPedido");}
}
