package com.example.moca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moca.Peliculas;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Peliculas> misdatos;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListAdapter(List<Peliculas> misdatos, Context context) {
        this.misdatos = misdatos;
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo,anio,descripcion,precio,director;
        ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.rc_Titulo);
            descripcion=itemView.findViewById(R.id.rc_Descripcion);
            anio=itemView.findViewById(R.id.rc_anio);
            precio=itemView.findViewById(R.id.rc_precio);
            director=itemView.findViewById(R.id.rc_Director);
            imagen=itemView.findViewById(R.id.rc_imagen);
        }

        public void juntardata(Peliculas item){
            titulo.setText(item.getTitulo());
            descripcion.setText(item.getDescripcion());
            anio.setText(item.getAnio());
            precio.setText(item.getPrecio());
            director.setText(item.getDirector());
            imagen.setImageResource(item.getImagen());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.contenido,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntardata(misdatos.get(position));
    }

    @Override
    public int getItemCount() {
        return misdatos.size();
    }

}

