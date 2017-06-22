package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jturco on 21/06/2017.
 */

public class ConexionPost {

    private JSONObject jsonRecibido=null;// lo instancio por las dudas.
    private byte[] outputInBytes = null;
    public ConexionPost(JSONObject jsonRecib)  // lo pongo mas generico asi puedo utilizar la misma clase para el AltaPedido

    {
        this.jsonRecibido=jsonRecib;
    }

    public byte[] postBytesData(String u) throws IOException { // lo hago así porque si responde 200 es true y desp lo manejo en mi handler
    URL url = new URL(u);
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setRequestMethod("POST");
    urlConnection.setDoOutput(true);     //esto pq es POST.
    urlConnection.setRequestProperty("Content-Type","applications/json");


    OutputStream os = urlConnection.getOutputStream();
    outputInBytes = jsonRecibido.toString().getBytes("UTF-8"); // esto seria como mandar toda el estructura de json para dar el alta (pasando todo esto a bytes):



        Log.d("Bytes enviado",outputInBytes.toString());


        //Log.d("ResponseAlta",String.valueOf(response));

        os.write(outputInBytes);
        urlConnection.connect();

        int response = urlConnection.getResponseCode();
        //os.close();

        if (response==200)
        {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;

            while((length = is.read(buffer))!= -1)
            {
                baos.write(buffer, 0 , length);
            }
            is.close();
            Log.d("baos",baos.toString());
            return baos.toByteArray(); //Devuelvo el mensaje para tratarlo en el handler.
        }
        else
            throw new IOException();
    }
}
