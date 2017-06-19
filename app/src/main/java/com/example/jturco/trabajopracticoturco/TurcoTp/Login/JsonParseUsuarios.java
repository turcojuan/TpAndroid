package com.example.jturco.trabajopracticoturco.TurcoTp.Login;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jturco on 18/06/2017.
 */

public class JsonParseUsuarios {

    public static List<ModelUsuarioLogin> parcear (String s) { //esta url api hay que setearla desde el hilo en como ej:rta.
        //aca tendria que devolver una lista?.

        List<ModelUsuarioLogin> listaUsuarios = new ArrayList<ModelUsuarioLogin>();
        String mail =null;


        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray usuarios = jsonObject.getJSONArray("usuarios");

             for ( int i =0; i< usuarios.length() ;i++ ) {
                 JSONObject aux = usuarios.getJSONObject(i);
                 ModelUsuarioLogin u = new ModelUsuarioLogin();
                 u.setNombre(aux.getString("nombre"));
                 u.setDni(aux.getInt("dni"));
                 u.setMail("mail");
                 listaUsuarios.add(u);
                 Log.d("ArrayUsers",u.getMail());
             }

          //  JSONObject jsonObject = new JSONObject(s);
          //  mail= jsonObject.getString("mail");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }


        //} catch (JSONException e1) {
         //   e1.printStackTrace();
        //}
        //return listaUsuarios;


}
