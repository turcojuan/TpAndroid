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

public class MyAdapterMenuPedido  extends RecyclerView.Adapter<MyViewHolderMenuPedido> { //le paso MyViewHolder para que sea de este tipo.
    private  List<ModelProductoMenu> listaMenuPedido;
    private IOnItemClickMenuPedido listenerRvMenuPedido;
    public MyAdapterMenuPedido (List<ModelProductoMenu> listaMenu,IOnItemClickMenuPedido listerner)
    {
        this.listaMenuPedido=listaMenu;
        this.listenerRvMenuPedido = listerner;
    }

    @Override
    public MyViewHolderMenuPedido onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_menu_producto,parent,false); //Te permite agarrar el xml y lo pasa a un objeto java de tipo view
        MyViewHolderMenuPedido vb= new MyViewHolderMenuPedido(v,listenerRvMenuPedido);
        Log.d("OnCreate","Es:toy:: en OnCreate");
        return vb;
    }

    @Override
    public void onBindViewHolder(MyViewHolderMenuPedido holder, int position) {

        ModelProductoMenu pm=listaMenuPedido.get(position);
        holder.tvNombreMenuProducto.setText(pm.getNombre());  //este holder es instancia de MyViewHolder
        holder.tvPrecioMenuProducto.setText(pm.getPrecio().toString()); // esto puede traer un error
        holder.setPosition(position);
        Log.d("OnBind","Estoy en OnBind");
    }

    @Override
    public int getItemCount() {
        Log.d("OnCount","Estoy en ItemCount");
        return this.listaMenuPedido.size();
    }
}
