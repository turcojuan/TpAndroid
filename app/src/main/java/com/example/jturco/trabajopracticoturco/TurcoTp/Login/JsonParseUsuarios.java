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

    public static List<ModelUsuarioLogin> parcear (String s) {
        //aca tendria que devolver una lista?.

        List<ModelUsuarioLogin> listaUsuarios = new ArrayList<ModelUsuarioLogin>();
        String mail =null;


        try {
            //JSONObject jsonObject = new JSONObject(s);
            //JSONArray usuarios = jsonObject.getJSONArray("usuarios");

            JSONArray usuarios = new JSONArray(s); //directamente lo que me devuelve la api lo convierto en Array


             for ( int i =0; i< usuarios.length() ;i++ ) {
                 JSONObject aux = usuarios.getJSONObject(i);
                 ModelUsuarioLogin u = new ModelUsuarioLogin();
                 u.setNombre(aux.getString("nombre"));
                 u.setDni(aux.getInt("dni"));
                 u.setPassword(aux.getString("clave"));
                 u.setMail(aux.getString("mail"));
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
