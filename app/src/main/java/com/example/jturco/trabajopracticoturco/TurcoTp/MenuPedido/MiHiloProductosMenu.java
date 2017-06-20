package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.jturco.trabajopracticoturco.TurcoTp.Login.Conexion;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.JsonParseUsuarios;

import java.io.IOException;

/**
 * Created by jturco on 18/06/2017.
 */

public class MiHiloProductosMenu implements Runnable {

    private String Url;
    private Handler miHandler;


    public MiHiloProductosMenu(Handler h) {
        miHandler = h;
    }

    @Override
    public void run() {

        Log.d("miHiloEjecutoProductos","miHiloEjecutoProductos");

        Message msg = new Message();
        //msg.arg1 = 1;

        try {
            Log.d("miHiloEjecuto4Productos","miHiloEjecuto4Productos");
            Conexion conexion = new Conexion(); // Quizas podria hacer un Singleton??.

            Log.d("miHiloEjecuto3Productos","miHiloEjecuto3Productos");
            String miStr= new String(conexion.getBytesDataByGet("http://192.168.1.34:3000/productos/")); // devuelve un array de byte y lo paso a Str

            //String urlApi= new String(conexion.getBytesDataByGet("http://localhost:3000/usuarios/a@a.com/clave")); // hago esto para probar.

            //esto tendria que asignarlo a msg.obj
            Log.d("miHiloEjecuto2Productos","miHiloEjecuto2Productos");
            msg.obj= JsonParseProductoMenu.parcear(miStr);
            miHandler.sendMessage(msg);
            Log.d("miHiloEjecuto1Productos","miHiloEjecuto1Productos");
        }
        catch(IOException e){}
    }
}
