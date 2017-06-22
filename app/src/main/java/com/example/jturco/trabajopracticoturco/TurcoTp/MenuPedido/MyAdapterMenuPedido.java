package com.example.jturco.trabajopracticoturco.TurcoTp.MenuPedido;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
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

//hago que adapter implemente el handMsg así lo recibo aca y ejecuto mi hilo desde aca.

public class MyAdapterMenuPedido  extends RecyclerView.Adapter<MyViewHolderMenuPedido> implements Handler.Callback{
    private  List<ModelProductoMenu> listaMenuPedido;
    ModelProductoMenu pm;
    private IOnItemClickMenuPedido listenerRvMenuPedido; // se implementa en el main.
    private Bitmap descargaImagenItem =null;
    private Bitmap auxdescargaImagenItem; // para intentar de no ir a buscar siempre.


    public MyAdapterMenuPedido (List<ModelProductoMenu> listaMenu,IOnItemClickMenuPedido listerner)
    {
        this.listaMenuPedido=listaMenu;
        this.listenerRvMenuPedido = listerner;

        //Ejecuto el metodo aca.

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
        pm=listaMenuPedido.get(position);

        if(pm.getImagenDescargada()== null){
        Handler hImagen = new Handler(this);
        Thread miHiloImagen = new Thread(new MiHiloImagen(hImagen,pm)); //Le paso el model completo y cargo la imagen en cada Run() del hilo y no pierdo el indice.
        miHiloImagen.setPriority(Thread.MAX_PRIORITY);
        miHiloImagen.start();}

        //Aca tengo que asignar los valores de los productos y llamar a un hilo para ir buscar la imagen
            //esta lista que recibo se la mando en el main y la tengo llenar con el get de la API
            //y aca le voy asignando al layout item(View holder) los atributos de mi lista.
        //aca podria hacer el star para mi hiloImagenes.

            Log.d("StringImagen"+pm.getNombre(),pm.getImagen().toString());

        holder.tvNombreMenuProducto.setText(pm.getNombre());  //este holder es instancia de MyViewHolder
        holder.tvPrecioMenuProducto.setText(pm.getPrecio().toString());// esto puede traer un error

        if(pm.getImagenDescargada()!=null) //si la imagen que traje tiene algo, recien ahi dejo de usa la por defecto
        {
        holder.imagenItem.setImageBitmap(pm.getImagenDescargada()); }
           // descargaImagenItem=null; }//lo paso a null para que traiga otra imagen}
        holder.setPosition(position); // seteo la position del item para el listener.
        Log.d("OnBind","Estoy en OnBind");
    }

    @Override
    public int getItemCount() {
        Log.d("OnCount","Estoy en ItemCount");
        return this.listaMenuPedido.size();
    }
    @Override
    public boolean handleMessage(Message msg) {
        Log.d("Respuesta", "Llego la respuesta del hilo");

        Boolean seDescargo = (Boolean) msg.obj;
        Log.d("HiloImagenHandle", seDescargo.toString());
        //this.descargaImagenItem = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        if(seDescargo==true)
            this.notifyDataSetChanged();
        return true;
    }


}
