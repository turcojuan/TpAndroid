package com.example.jturco.trabajopracticoturco.TurcoTp.MiPedido;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jturco.trabajopracticoturco.R;
import com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido.IOnItemClickMenuPedido;

/**
 * Created by jturco on 17/05/2017.
 */

public class MyViewHolderMiPedido extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombreMiProducto;
    TextView tvPrecioMiProducto;
    ImageView imagenItem;

    Button btnEliminarMiPedido;
    private IOnItemClickMiPedido listenerMiPedido;
    private int position;

    public MyViewHolderMiPedido(View itemView, IOnItemClickMiPedido listenerMiP) {
        super(itemView);
        tvNombreMiProducto = (TextView) itemView.findViewById(R.id.tvNombreMiProducto);
        tvPrecioMiProducto = (TextView) itemView.findViewById(R.id.tvPrecioMiProducto);
        //aca agregar la imagen
        imagenItem= (ImageView) itemView.findViewById(R.id.imageViewMiPedido);
        btnEliminarMiPedido= (Button) itemView.findViewById(R.id.btnEliminarMiPedido);
        this.listenerMiPedido =listenerMiP;
        btnEliminarMiPedido.setOnClickListener(this); // le paso el litener al btn en lugar que al item entero

    }
    public void setPosition(int position)

    {
        this.position = position; //desde le vh no conozco la posicion, pero hago esto para pasarsela desde el Adapter
    }


    @Override
    public void onClick(View view) {
        listenerMiPedido.onItemClick(position); // este onItemClick lo implemento en el activity


    }
}
