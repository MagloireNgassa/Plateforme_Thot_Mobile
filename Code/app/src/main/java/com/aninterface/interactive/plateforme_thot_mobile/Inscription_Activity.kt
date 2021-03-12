package com.aninterface.interactive.plateforme_thot_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class Inscription_Activity : AppCompatActivity() {

    lateinit var reponses: String
    fun  reponse(reponse:String)
    {
        this.reponses = reponse
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription_)

        val etudiant = intent.getParcelableExtra<Etudiant> ("etud")
        val etudiant1 : Etudiant = Etudiant("Magloire","ngassa","primaire","mag_2kjhg")
        val r1 : BackWorkerIns = BackWorkerIns(this,etudiant)
        val t : Thread = Thread(r1)
        t.start();

        if(reponses.equals("reussi"))
        {
            //etudiant1.envoie_message_confirmation(this)
        }

        else if (reponses.equals("doublon"))
        {
           //etudiant. message_erreur_doublon_mail(this)
        }
        else
        {
            //etudiant1.message_erreur_enregistrement(this)
        }

    }
}
