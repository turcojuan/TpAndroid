package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jturco on 18/06/2017.
 */

public class Conexion {
    public byte[] getBytesDataByGet(String u) throws IOException{
        Log.d("miConexion","miConexion");

        URL url = new URL(u);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        Log.d("miConexion1","miConexion1");
        urlConnection.connect();
        Log.d("miConexion2","miConexion2");
        int response = urlConnection.getResponseCode();
        Log.d("miConexion3",String.valueOf(response));
        Log.d("http", "Response code: " + response);
        if(response == 200) { // evaluo la respuesta del server, 200 es OK.
            InputStream is = urlConnection.getInputStream(); // descargo lo que el server me trae
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //en baos voy a tener el mensaje
            byte[] buffer = new byte[1024];
            int length = 0;
            while((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);  //voy escribiendo en el buffer, siempre y cuando tenga que leer
            }
            is.close();
            return baos.toByteArray(); //Entonces con esto retorno lo del Get.
        }
        else throw new IOException();
    }

}
