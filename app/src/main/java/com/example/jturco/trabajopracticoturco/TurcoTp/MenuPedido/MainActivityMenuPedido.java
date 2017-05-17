package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.MainActivity;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ControladorUsuarioRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ListenerRegistar;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MainActivityRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.MiDialogoRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ModelUsuarioRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.VistaUsuarioRegistro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jturco on 14/05/2017.
 */

public class MainActivityMenuPedido extends AppCompatActivity implements IOnItemClickMenuPedido {
  private  List<ModelProductoMenu> listaMenuProd;
  private  List<ModelProductoMenu> listaMenuProdSeleccionados=new ArrayList<ModelProductoMenu>();
  private  VistaMenuPedido miVistaMenuPedido;
    private static final String MAIL = "mail";
    private static final String PASSWORD = "pass";


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
        listaMenuProd.add(new ModelProductoMenu("Hamburgesa",70.00));
        listaMenuProd.add(new ModelProductoMenu("Milanesas",80.00));
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

            this.finish();


            //Borrar los datos de preference
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
        //Llamar aca a un metodo de vista para que set a Importe el valor del item seleccionado

        Log.d("Se hizo click el item"+position,"RVlist");
        miVistaMenuPedido.calcularImporte(listaMenuProd.get(position));
        miVistaMenuPedido.calcularElementosSel();
        //Llamo a un metodo para agregar el item a una nueva lista
            listaMenuProdSeleccionados.add(listaMenuProd.get(position));
            Log.d("Agregoooo a:",listaMenuProd.get(position).getNombre().toString());

    }

    public List<ModelProductoMenu> getListaMenuProdSeleccionados() {
        Log.d("Carga:",String.valueOf(listaMenuProdSeleccionados.size()));
        return listaMenuProdSeleccionados;

    }


    public void mostrarDialogo()
    {MiDialogoMenuPedido dialog = new MiDialogoMenuPedido();
        dialog.show(getSupportFragmentManager(), "dialogoMenuPedido");}

}
