package com.example.jturco.trabajopracticoturco.TurcoTp.Registro;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.jturco.trabajopracticoturco.TurcoTp.Login.Conexion;
import com.example.jturco.trabajopracticoturco.TurcoTp.Login.JsonParseUsuarios;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.JsonParseProductoMenu;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by jturco on 21/06/2017.
 */

public class MiHiloAltaUser implements Runnable {

    private String Url;
    private Handler miHandler;
    private UserRegistrado userRegis;


    public MiHiloAltaUser(Handler h, UserRegistrado userR) {
        miHandler = h;
        this.userRegis = userR;
    }

    @Override
    public void run() {


        Message msg = new Message();


        try {

            //mi User lo paso a Jsonobj para desp mandarlo por Const a Conexion y que lo suba como "datos".
            JSONObject jsonObjUser = new JSONObject();
            jsonObjUser.put("nombre", userRegis.getNombre().toString());
            jsonObjUser.put("apellido", userRegis.getApellido().toString());
            jsonObjUser.put("dni", userRegis.getDni().toString());
            jsonObjUser.put("mail", userRegis.getMail().toString());
            jsonObjUser.put("clave", userRegis.getClave().toString());

            ConexionPost conexionPost = new ConexionPost(jsonObjUser);
            //String miStr= new String(conexion.getBytesDataByGet("http://192.168.1.34:3000/usuarios/")); // devuelve un array de byte y lo paso a Str

            Log.d("HastaAcaOkAlta","HastaAcaOkAlta");

            //por si quiero recibir el mensaje.

            String respuestaPost= new String(conexionPost.postBytesData("http://192.168.1.36:3000/usuarios/nuevo"));
            //String miStrRespAlta= new String(conexionPost.postBytesData("http://192.168.1.34:3000/usuarios/nuevo"));
            //tengo que hacer un JsonParse para evaluar la respuesta, fijarme en mi ej de la clase8

            JSONObject respAltaUser = new JSONObject(respuestaPost);  // lo hago aca para no hacer un parser nuevo.
            String mensajePost= respAltaUser.getString("mensaje");      //Hago el jsonObj median la cadena para obtener le mensaje.

             msg.obj=mensajePost;

            miHandler.sendMessage(msg);
            Log.d("miHiloEjecuto1", "miHiloEjecuto1");

        } catch (JSONException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}