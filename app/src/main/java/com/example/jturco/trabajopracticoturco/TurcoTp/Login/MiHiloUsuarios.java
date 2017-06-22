package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

/**
 * Created by jturco on 18/06/2017.
 */

public class MiHiloUsuarios implements Runnable {

    private String Url;
    private Handler miHandler;


    public MiHiloUsuarios(Handler h) {
        miHandler = h;
    }

    @Override
    public void run() {

        Log.d("miHiloEjecuto","miHiloEjecuto");

        Message msg = new Message();
        //msg.arg1 = 1;

        try {
            Log.d("miHiloEjecuto4","miHiloEjecuto4");
            Conexion conexion = new Conexion(); // Quizas podria hacer un Singleton??.

            Log.d("miHiloEjecuto3","miHiloEjecuto3");
             String miStr= new String(conexion.getBytesDataByGet(MainActivity.ipApi+"/usuarios/")); // devuelve un array de byte y lo paso a Str
           // String miStr= new String(conexion.getBytesDataByGet("http://127.0.0.1:3000/usuarios/")); // devuelve un array y lo paso a Str

            //String urlApi= new String(conexion.getBytesDataByGet("http://localhost:3000/usuarios/a@a.com/clave")); // hago esto para probar.

            //esto tendria que asignarlo a msg.obj
            Log.d("miHiloEjecuto2","miHiloEjecuto2");
            msg.obj= JsonParseUsuarios.parcear(miStr);

            miHandler.sendMessage(msg);

            Log.d("miHiloEjecuto1","miHiloEjecuto1");
        }
        catch(IOException e){}
    }
}
