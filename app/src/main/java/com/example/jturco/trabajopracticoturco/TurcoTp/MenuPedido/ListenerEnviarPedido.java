package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.util.Log;
import android.view.View;

import com.example.jturco.trabajopracticoturco.R;


/**
 * Created by jturco on 16/05/2017.
 */

public class ListenerEnviarPedido implements View.OnClickListener {

    IEnviarPedido iEp;

    public ListenerEnviarPedido(IEnviarPedido enviarPedido) {
        this.iEp = enviarPedido;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnEnviarPedidoMenuP) {
            Log.d("Click en EnviarPedido","Click en EnviarPedido");
            iEp.enviarPedidoMenuSelecionado();

        }
    }
}
