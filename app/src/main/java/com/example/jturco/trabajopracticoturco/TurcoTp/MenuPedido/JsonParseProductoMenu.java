package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ModelUsuarioLogin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.jturco.trabajopracticoturco.R.drawable.usuarios;

/**
 * Created by jturco on 18/06/2017.
 */

public class JsonParseProductoMenu {

    public static List<ModelProductoMenu> parcear(String s) { //esta url api hay que setearla desde el hilo en como ej:rta.
        //aca tendria que devolver una lista?.

        List<ModelProductoMenu> listaProductos = new ArrayList<ModelProductoMenu>();


        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray productos = jsonObject.getJSONArray("menuesJson");

            for (int i = 0; i < productos.length(); i++) {
                JSONObject aux = productos.getJSONObject(i);
                ModelProductoMenu p = new ModelProductoMenu();
                p.setNombre(aux.getString("nombre"));
                p.setPrecio(Double.valueOf(aux.getInt("precio")));

                String tipoM= aux.getString("tipoMenu");
                String imagen=aux.getString("imagen");

                // p.setMail("mail");
                listaProductos.add(p);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }

}