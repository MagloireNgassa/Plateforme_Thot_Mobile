package com.aninterface.interactive.plateforme_thot_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Affiche_Adapter extends ArrayAdapter<Cours> {

    private Context context;
    private ArrayList<Cours> ar;
    private int resource;

    public Affiche_Adapter( Context context, int resource,  List<Cours> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        ar = new ArrayList<Cours>();
        ar = (ArrayList<Cours>)objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Cours ctemp = this.ar.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);

        TextView nomCours = (TextView)convertView.findViewById(R.id.nomCours);
        TextView niveauCours = (TextView)convertView.findViewById(R.id.niveauCours);
        TextView nomProfesseur = (TextView)convertView.findViewById(R.id.nomProfesseur);
        TextView descriptionCours = (TextView)convertView.findViewById(R.id.descriptionCours);
        TextView btnInsCours = (TextView)convertView.findViewById(R.id.btnInsCours);
        ImageView img =(ImageView)convertView.findViewById(R.id.image);

        nomCours.setText(ctemp.getNom_cours());
        niveauCours.setText(ctemp.getNiveau_cours());
        nomProfesseur.setText(ctemp.getId_professeur());
        descriptionCours.setText(ctemp.getDesscription_cours());
        img.setImageResource(Integer.parseInt(String.valueOf(ctemp.getPhoto())));

        return convertView;
    }
}
