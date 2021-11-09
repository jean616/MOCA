package com.example.moca;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ListAdapterr extends RecyclerView.Adapter<ListAdapterr.ViewHolder> {
    private List<usuario> misdatos1;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListAdapterr(List<usuario> misdatos1, Context context) {
        this.misdatos1 = misdatos1;
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,contraseña,email,id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.ettnombre);
            contraseña=itemView.findViewById(R.id.ettcontraseña);
            email=itemView.findViewById(R.id.ettemail);
            id=itemView.findViewById(R.id.ettID);
        }

        public void juntardataa(usuario item){
            nombre.setText(item.getNombre());
            contraseña.setText(item.getContraseña());
            email.setText(item.getEmail());
    }
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.lista_usuarios,parent,false);
        return new ListAdapterr.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntardataa(misdatos1.get(position));
    }

    @Override
    public int getItemCount() {
        return misdatos1.size();
    }
}
