package com.aninterface.interactive.plateforme_thot_mobile

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast

class Etudiant(var nom: String, var prenom:String, var niveau_scolaire:String, var email:String):
    Parcelable
{
    constructor( nom: String,  prenom:String,  niveau_scolaire:String,  email:String,reponses:String):this(nom,prenom,niveau_scolaire,email)

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

    fun traitement_info_enregistrement(reponse: String): Boolean
    {
        val reponses: String  = reponse
        if (reponses.equals("reussi"))
            return true
        else
            return false
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        dialog.cancel()
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
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
//override parcellable
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeString(niveau_scolaire)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Etudiant> {
        override fun createFromParcel(parcel: Parcel): Etudiant {
            return Etudiant(parcel)
        }

        override fun newArray(size: Int): Array<Etudiant?> {
            return arrayOfNulls(size)
        }
    }

}