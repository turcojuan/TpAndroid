package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.util.Log;
import android.view.View;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.IEnviarPedido;

/**
 * Created by jturco on 17/05/2017.
 */

public class ListenerEnviarMiPedido implements View.OnClickListener {

    IEnviarMiPedido iEmP;

    public ListenerEnviarMiPedido(IEnviarMiPedido enviarMiPedido) {
        this.iEmP = enviarMiPedido;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnEnviarPedidoMiPedido) {
            Log.d("Click en EnviarMiPedido","Click en EnviarMiPedido");
            iEmP.mostrarPedidoSelecionado();

        }
    }
}
