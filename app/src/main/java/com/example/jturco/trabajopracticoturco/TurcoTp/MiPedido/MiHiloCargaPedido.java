package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.jturco.trabajopracticoturco.TurcoTp.Login.ControladorUsuarioLogin;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.ConexionPost;
import com.example.jturco.trabajopracticoturco.TurcoTp.Registro.UserRegistrado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by jturco on 21/06/2017.
 */

public class MiHiloCargaPedido implements Runnable {

    private String Url;
    private Handler miHandler;
    private List<ModelProductoMenu> listaProdSel;


    public MiHiloCargaPedido(Handler h, List<ModelProductoMenu> listaP) {
        miHandler = h;
        this.listaProdSel = listaP;
    }

    @Override
    public void run() {


        Message msg = new Message();


        try {


            //mi User lo paso a Jsonobj para desp mandarlo por Const a Conexion y que lo suba como "datos".

            //Aca lo que intento hacer (segun al estructura que recibe la api) es una JsonObj general y dentro de este de inserto un array con todos los datos los prod seleccionados.
            JSONObject miPedidoCompleto = new JSONObject();

            miPedidoCompleto.put("usuario", ControladorUsuarioLogin.userLogueado); //uso atrib static de Login
            JSONArray pedidos = new JSONArray();
            for (ModelProductoMenu miProd:listaProdSel) {

                JSONObject jsonPedido = new JSONObject();


                jsonPedido.put("tipoMenu", miProd.getTipoMenu().toString());
                jsonPedido.put("nombre", miProd.getNombre().toString());
                jsonPedido.put("precio", miProd.getPrecio().toString());
                jsonPedido.put("imagen", miProd.getImagen().toString());

                pedidos.put(jsonPedido);
            }

            miPedidoCompleto.put("pedido", pedidos); //aca asocio el array a mi json gral.


            ConexionPost conexionPost = new ConexionPost(miPedidoCompleto);

            //String miStr= new String(conexion.getBytesDataByGet("http://192.168.1.34:3000/usuarios/")); // devuelve un array de byte y lo paso a Str

            Log.d("HastaAcaOkAlta","HastaAcaOkAlta");

            //por si quiero recibir el mensaje.

            //String respuestaPost = conexionPost.postBytesData("http://192.168.1.36:3000/pedidos/nuevo");

            String respuestaPost= new String(conexionPost.postBytesData("http://192.168.1.36:3000/pedidos/nuevo"));
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
