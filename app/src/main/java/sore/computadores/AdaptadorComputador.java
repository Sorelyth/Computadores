package sore.computadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 28/05/2018.
 */

public class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder>{
    private ArrayList<Computador> computadores;
    private OnComputadorClickListener clickListener;

    public AdaptadorComputador(ArrayList<Computador> computadores, OnComputadorClickListener clickListener){
        this.computadores=computadores;
        this.clickListener = clickListener;
    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_computador,parent,false);
        return new ComputadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador C = computadores.get(position);
        holder.foto.setImageResource(C.getFoto());
        holder.marca.setText(C.getMarca());
        holder.ram.setText(C.getRam());
        holder.color.setText(C.getColor());
        holder.so.setText(C.getSO());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onComputadorClick(C);
            }
        });
    }

    @Override
    public int getItemCount() {
        return computadores.size();
    }

    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView ram;
        private TextView color;
        private TextView so;
        private View v;

        public ComputadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            //foto = v.findViewById(R.id.imgFoto);
            //marca = v.findViewById(R.id.lblMarca);
            //ram = v.findViewById(R.id.lblRam);
            //color = v.findViewById(R.id.lblColor);
            //so = v.findViewById(R.id.lblSO);
        }
    }

    public interface OnComputadorClickListener{
        void onComputadorClick(Computador C);
    }
}
