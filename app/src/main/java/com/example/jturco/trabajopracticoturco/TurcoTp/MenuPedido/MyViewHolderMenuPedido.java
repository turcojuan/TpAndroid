package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

/**
 * Created by jturco on 15/05/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.R;

public class MyViewHolderMenuPedido extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombreMenuProducto;
    TextView tvPrecioMenuProducto;
    TextView tvImporteEstimadoMenuP;
    Button btnAgregarMenuPedido;
    private IOnItemClickMenuPedido listenerMenuPedido;
    private int position;

    public MyViewHolderMenuPedido(View itemView, IOnItemClickMenuPedido listenerMenuP) {
        super(itemView);
        tvNombreMenuProducto = (TextView) itemView.findViewById(R.id.tvNombreMenuProducto);
        tvPrecioMenuProducto = (TextView) itemView.findViewById(R.id.tvPrecioMenuProducto);
        tvImporteEstimadoMenuP= (TextView) itemView.findViewById(R.id.tvImporteEstimadoMenuP);
        btnAgregarMenuPedido= (Button) itemView.findViewById(R.id.btnAgregarMenuPedido);
        this.listenerMenuPedido =listenerMenuP;
        btnAgregarMenuPedido.setOnClickListener(this); // le paso el litener al btn en lugar que al item entero

    }
    public void setPosition(int position)

    {
        this.position = position; //desde le vh no conozco la posicion, pero hago esto para pasarsela desde el Adapter
    }


    @Override
    public void onClick(View view) {
        listenerMenuPedido.onItemClick(position); // este onItemClick lo implemento en el activity, el paso position que lo seteo desde el bind del Adapter


    }
}
