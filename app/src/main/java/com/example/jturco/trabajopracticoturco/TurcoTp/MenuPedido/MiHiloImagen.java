package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.jturco.trabajopracticoturco.TurcoTp.Login.Conexion;

import java.io.IOException;

/**
 * Created by jturco on 20/06/2017.
 */

public class MiHiloImagen implements Runnable {

    private String Url;
    private Handler miHandler;
    private String urlImagenItem;


    public MiHiloImagen(Handler h,String urlImagen) {
        miHandler = h;
        urlImagenItem= urlImagen;
    }

    @Override
    public void run() {

        Log.d("SeEjecutamiHiloImagen","SeEjecutamiHiloImagen");

        Message msg = new Message();
        //msg.arg1 = 1;

        try {
            Log.d("miHiloEjecuto4Imagen","miHiloEjecuto4Imagen");
            Conexion conexion = new Conexion(); // Quizas podria hacer un Singleton??.

            Log.d("miHiloEjecuto3Imagen","miHiloEjecuto3Imagen");
            byte[] respuestaImagen = conexion.getBytesDataByGet(urlImagenItem); // devuelve un array de byte y lo paso a Str

            //String urlApi= new String(conexion.getBytesDataByGet("http://localhost:3000/usuarios/a@a.com/clave")); // hago esto para probar.

            //esto tendria que asignarlo a msg.obj
            Log.d("miHiloEjecuto2Imagen","miHiloEjecuto2Imagen");
            msg.obj= respuestaImagen;
            miHandler.sendMessage(msg);
            Log.d("miHiloEjecuto1Imagen","miHiloEjecuto1Imagen");
        }
        catch(IOException e){}
    }
}