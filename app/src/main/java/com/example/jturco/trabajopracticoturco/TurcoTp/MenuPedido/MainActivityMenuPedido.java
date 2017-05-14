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

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

     /*   @Override
        public boolean onCreateOptionsMenu(MenuView menu){
// Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }*/




    }
}
