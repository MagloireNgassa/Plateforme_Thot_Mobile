package com.aninterface.interactive.plateforme_thot_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_affiche_cours_.*

class AfficheCours_Activity : AppCompatActivity() {

    lateinit var ListOfItem:ArrayList<Cours>
    lateinit var ad:Affiche_Adapter
    lateinit var listeviews: ListView
    lateinit var reponses: String
    fun  reponse(reponse:String)
    {
        this.reponses = reponse
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affiche_cours_)

        var tabline:List<String> = this.reponses.split("@");
        for ( i  in 0..tabline.count()-1) {
           var tabmot:List<String> = tabline[i].split("/");
            val temp: Cours = Cours(tabmot[0],tabmot[1],tabmot[2],tabmot[3],(tabmot[4].toString()))

            ListOfItem.add(temp)
            ad = Affiche_Adapter(this,R.layout.layout_affiche_cours,ListOfItem)
        }

        listeviews = findViewById(R.id.listeview)
        listeviews.adapter = ad
    }
}
