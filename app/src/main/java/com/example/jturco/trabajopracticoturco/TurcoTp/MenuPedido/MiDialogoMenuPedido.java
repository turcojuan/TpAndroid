package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ListenerDialogo;

/**
 * Created by jturco on 16/05/2017.
 */

public class MiDialogoMenuPedido extends android.support.v4.app.DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(this.getContext());
        builder.setTitle(R.string.dialog_menu_pedido_titulo);
        builder.setMessage(R.string.dialog_menu_pedido);


        builder.setNeutralButton(R.string.dialog_menu_pedido_btn, new ListenerDialogo());
        AlertDialog ad= builder.create();

        return ad;
    }
}
