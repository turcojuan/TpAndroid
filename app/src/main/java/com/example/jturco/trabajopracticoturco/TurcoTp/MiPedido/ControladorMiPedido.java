package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ListenerEnviarPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.MainActivityMenuPedido;

/**
 * Created by jturco on 14/05/2017.
 */

public class ControladorMiPedido {


    ListenerEnviarMiPedido miListenerEnviarMiPedido;
    MainActivityMiPedido actividadMiPedido;

    public ControladorMiPedido(ListenerEnviarMiPedido env) {

        this.miListenerEnviarMiPedido = env;

    }

    public ListenerEnviarMiPedido getMiListenerEnviarMiPedido()
    { //esto lo hago para poder hacer el btn.SetOnClick (para pasarle el listener) en la vista (Si o si hay que pasarlo en la vista).
        return miListenerEnviarMiPedido;
    }
}
