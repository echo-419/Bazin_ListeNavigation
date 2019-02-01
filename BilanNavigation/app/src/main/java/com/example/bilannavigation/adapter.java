package com.example.bilannavigation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private String[] Donnée;
    ViewHolder holder;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Y declarer les objets de la vue qui seront chargés (par le tableau de données)
        public TextView mTextView;
        public ImageView mImageView;

        //Constructeur du holder : le viewHolder a une reference vers tous les objets de la liste
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.TV_NomLigne);
        }
    }

    //Constructeur de l'adaptateur : initialisations de l’adapter et des données
    public adapter(String[] monDataset) {
        Donnée = monDataset;

    }

    //Chargement du layout et initialisation du viewHolder
    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_ligne, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    //Lien entre viewHolder et données
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(Donnée[position]);
    }


    //Nombre d’éléments de la liste
    @Override public int getItemCount() {

        return Donnée.length;
    }
}