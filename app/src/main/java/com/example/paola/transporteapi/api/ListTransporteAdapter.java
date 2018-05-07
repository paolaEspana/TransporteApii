package com.example.paola.transporteapi.api;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.paola.transporteapi.R;

import java.util.ArrayList;

public class ListTransporteAdapter extends RecyclerView.Adapter<ListTransporteAdapter.ViewHolder>
{
    private ArrayList<EmpresaTransporte> dataset;
    private Context context;
    private EmpresaTransporte empresa;

    public ListTransporteAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empresa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTransporteAdapter.ViewHolder holder, int position)
    {
        empresa = dataset.get(position);

        holder.nombreTextView.setText(empresa.getNombre_de_la_empresa());
        holder.nombreTextView2.setText(empresa.getDirecci_n());
        holder.nombreTextView3.setText( empresa.getTel_fono());
        holder.nombreTextView4.setText(empresa.getTipo_de_empresa());
        holder.nombreTextView5.setText(empresa.getClase());
        holder.nombreTextView6.setText( empresa.getModalidad());
        holder.nombreTextView7.setText( empresa.getNit());
        holder.nombreTextView8.setText(empresa.getRadio_de_acci_n());
        holder.nombreTextView9.setText( empresa.getCiudad_de_la_sede_principal_de_la_empresa());
        Glide.with(context);
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }

    public void adicionarEmpresa(ArrayList<EmpresaTransporte> listaEmpresa) {
        dataset.addAll(listaEmpresa);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView nombreTextView;
        private TextView nombreTextView2;
        private TextView nombreTextView3;
        private TextView nombreTextView4;
        private TextView nombreTextView5;
        private TextView nombreTextView6;
        private TextView nombreTextView7;
        private TextView nombreTextView8;
        private TextView nombreTextView9;
        private CardView tarjetas;

        public ViewHolder(View itemView) {
            super(itemView);
            nombreTextView = (TextView) itemView.findViewById(R.id.textView1);
            nombreTextView2 = (TextView) itemView.findViewById(R.id.textView2);
            nombreTextView3 = (TextView) itemView.findViewById(R.id.textView3);
            nombreTextView4 = (TextView) itemView.findViewById(R.id.textView4);
            nombreTextView5 = (TextView) itemView.findViewById(R.id.textView5);
            nombreTextView6 = (TextView) itemView.findViewById(R.id.textView6);
            nombreTextView7 = (TextView) itemView.findViewById(R.id.textView7);
            nombreTextView8 = (TextView) itemView.findViewById(R.id.textView8);
            nombreTextView9= (TextView) itemView.findViewById(R.id.textView9);
            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
        }

    }

}
