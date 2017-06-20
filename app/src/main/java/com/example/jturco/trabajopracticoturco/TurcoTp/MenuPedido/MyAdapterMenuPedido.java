package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jturco.trabajopracticoturco.R;

import java.util.List;

/**
 * Created by jturco on 15/05/2017.
 */

public class MyAdapterMenuPedido  extends RecyclerView.Adapter<MyViewHolderMenuPedido> {
    private  List<ModelProductoMenu> listaMenuPedido;
    private IOnItemClickMenuPedido listenerRvMenuPedido; // se implementa en el main.

    public MyAdapterMenuPedido (List<ModelProductoMenu> listaMenu,IOnItemClickMenuPedido listerner)
    {
        this.listaMenuPedido=listaMenu;
        this.listenerRvMenuPedido = listerner;
    }

    @Override
    public MyViewHolderMenuPedido onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_menu_producto,parent,false); //Te permite agarrar el xml y lo pasa a un objeto java de tipo view, tranformo a view
        MyViewHolderMenuPedido vb= new MyViewHolderMenuPedido(v,listenerRvMenuPedido); //le paso lo que recibo por el constructor

        Log.d("OnCreate","Es:toy:: en OnCreate");
        return vb;
    }

    @Override
    public void onBindViewHolder(MyViewHolderMenuPedido holder, int position) {

        //Aca tengo que asignar los valores de los productos y llamar a un hilo para ir buscar la imagen
            //esta lista que recibo se la mando en el main y la tengo llenar con el get de la API
            //y aca le voy asignando al layout item(View holder) los atributos de mi lista.
        ModelProductoMenu pm=listaMenuPedido.get(position);
        holder.tvNombreMenuProducto.setText(pm.getNombre());  //este holder es instancia de MyViewHolder
        holder.tvPrecioMenuProducto.setText(pm.getPrecio().toString()); // esto puede traer un error
        holder.setPosition(position); // seteo la position del item para el listener.
        Log.d("OnBind","Estoy en OnBind");
    }

    @Override
    public int getItemCount() {
        Log.d("OnCount","Estoy en ItemCount");
        return this.listaMenuPedido.size();
    }
}
