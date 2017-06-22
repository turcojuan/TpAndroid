package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.IOnItemClickMenuPedido;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.ModelProductoMenu;


import java.util.List;

/**
 * Created by jturco on 17/05/2017.
 */

public class MyAdapterMiPedido extends RecyclerView.Adapter<MyViewHolderMiPedido> {
    private  List<ModelProductoMenu> listaMiPedido;
    private IOnItemClickMiPedido listenerRvMiPedido; // se implementa en el main.

    public MyAdapterMiPedido (List<ModelProductoMenu> listaMiPedido, IOnItemClickMiPedido listerner)
    {
        this.listaMiPedido=listaMiPedido;
        this.listenerRvMiPedido = listerner;
    }

    @Override
    public MyViewHolderMiPedido onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_mis_productos,parent,false); //Te permite agarrar el xml y lo pasa a un objeto java de tipo view
        MyViewHolderMiPedido vb= new MyViewHolderMiPedido(v,listenerRvMiPedido); //le paso lo que recibo por el constructor

        Log.d("OnCreate","Es:toy:: en OnCreate");
        return vb;
    }

    @Override
    public void onBindViewHolder(MyViewHolderMiPedido holder, int position) {

        ModelProductoMenu pm=listaMiPedido.get(position);
        holder.tvNombreMiProducto.setText(pm.getNombre());  //este holder es instancia de MyViewHolder
        holder.tvPrecioMiProducto.setText(pm.getPrecio().toString()); // esto puede traer un error
        if (pm.getImagenDescargada()!=null) {
            holder.imagenItem.setImageBitmap(pm.getImagenDescargada());
        }
        holder.setPosition(position);// seteo la position del item para el listener.
        Log.d("OnBind","Estoy en OnBind");
    }

    @Override
    public int getItemCount() {
        Log.d("OnCount","Estoy en ItemCount");
        return this.listaMiPedido.size();
    }
}
