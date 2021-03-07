package com.aninterface.interactive.plateforme_thot_mobile

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.widget.Toast

class Etudiant(var nom: String, var prenom:String, var niveau_scolaire:String, var email:String, var reponses:String )
{


    fun verification_mail()
     {

     }

    fun message_erreur_doublon_mail(context: Context)
    {
        val ad:AlertDialog = AlertDialog.Builder(context).create()
        ad.setTitle("ERREUR D'INSCRIPTION")
        ad.setMessage("Le mail que vous utilisez exist déjà ")
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"ok",DialogInterface.OnClickListener(function = positiveButtonClick))
        ad.show()
    }

    fun traitement_info_enregistrement(reponse: String)
    {
        this.reponses = reponse
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        dialog.cancel()
    }

    fun message_erreur_enregistrement(context: Context)
    {
        val ad:AlertDialog = AlertDialog.Builder(context).create()
        ad.setTitle("ERREUR D'ENREGISTREMENT")
        ad.setMessage("Votre inscription n'a pas pu être effectué veillez recommencer plutard")
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"ok",DialogInterface.OnClickListener(function = positiveButtonClick))
        ad.show()
    }

    fun mail()
    {

    }

    fun envoie_mail()
    {

    }

    fun envoie_message_confirmation(context: Context)
    {
        Toast.makeText(context,"Inscription reussi Bievenue Mr "+this.nom,Toast.LENGTH_LONG).show()
    }

}