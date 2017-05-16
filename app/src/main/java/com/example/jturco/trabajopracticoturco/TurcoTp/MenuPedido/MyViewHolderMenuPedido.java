package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

/**
 * Created by jturco on 15/05/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.R;

public class MyViewHolderMenuPedido extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombreMenuProducto;
    TextView tvPrecioMenuProducto;
    TextView tvImporteEstimadoMenuP;
    private IOnItemClickMenuPedido listenerMenuPedido;
    private int position;

    public MyViewHolderMenuPedido(View itemView, IOnItemClickMenuPedido listenerMenuP) {
        super(itemView);
        tvNombreMenuProducto = (TextView) itemView.findViewById(R.id.tvNombreMenuProducto);

        tvPrecioMenuProducto = (TextView) itemView.findViewById(R.id.tvPrecioMenuProducto);
        tvImporteEstimadoMenuP= (TextView) itemView.findViewById(R.id.tvImporteEstimadoMenuP);

        this.listenerMenuPedido =listenerMenuP;
        itemView.setOnClickListener(this);

    }
    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public void onClick(View view) {
        listenerMenuPedido.onItemClick(position);

    }
}
