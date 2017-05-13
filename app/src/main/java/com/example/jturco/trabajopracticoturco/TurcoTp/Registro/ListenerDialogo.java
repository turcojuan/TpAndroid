package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.content.DialogInterface;
import android.util.Log;

/**
 * Created by jturco on 12/05/2017.
 */

public class ListenerDialogo implements DialogInterface.OnClickListener {


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {  //el int te indica cual de todos fue

        Log.d("ad","MiDialogo");
    }
}
