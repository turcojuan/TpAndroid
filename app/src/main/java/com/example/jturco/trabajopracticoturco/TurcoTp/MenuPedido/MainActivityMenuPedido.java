package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toolbar;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ControladorUsuarioRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ListenerRegistar;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ModelUsuarioRegistro;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.VistaUsuarioRegistro;

/**
 * Created by jturco on 14/05/2017.
 */

public class MainActivityMenuPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pedido);

       /* ModelUsuarioRegistro miModeloRegistro= new ModelUsuarioRegistro();
        VistaUsuarioRegistro miVistaRegistro = new VistaUsuarioRegistro(this); //Le paso la instancia de la activity_main
        ControladorUsuarioRegistro miControladorRegistro = new ControladorUsuarioRegistro((new ListenerRegistar(miVistaRegistro))); // le pasas mi vista porque implementa IMostrarResultado
        miVistaRegistro.setMiControlador(miControladorRegistro);*/

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();

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
}
