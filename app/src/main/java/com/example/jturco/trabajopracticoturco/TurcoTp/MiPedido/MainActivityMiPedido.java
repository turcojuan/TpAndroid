package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jturco.trabajopracticoturco.R;

/**
 * Created by jturco on 14/05/2017.
 */

public class MainActivityMiPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_pedido);

       /* ModelUsuarioRegistro miModeloRegistro= new ModelUsuarioRegistro();
        VistaUsuarioRegistro miVistaRegistro = new VistaUsuarioRegistro(this); //Le paso la instancia de la activity_main
        ControladorUsuarioRegistro miControladorRegistro = new ControladorUsuarioRegistro((new ListenerRegistar(miVistaRegistro))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaRegistro.setMiControlador(miControladorRegistro);*/

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.hide();

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
    }
