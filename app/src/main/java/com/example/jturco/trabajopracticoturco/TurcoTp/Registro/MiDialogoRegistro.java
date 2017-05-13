package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.jturco.trabajopracticoturco.R;

/**
 * Created by jturco on 12/05/2017.
 */

public class MiDialogoRegistro extends android.support.v4.app.DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(this.getContext());
        builder.setTitle(R.string.dialog_registro_titulo);
        builder.setMessage(R.string.dialog_registro);


        builder.setNegativeButton(R.string.dialog_registro_btn, new ListenerDialogo());
        AlertDialog ad= builder.create();

        return ad;
    }
}
