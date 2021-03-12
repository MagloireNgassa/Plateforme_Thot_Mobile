package com.aninterface.interactive.plateforme_thot_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txv: TextView
    lateinit var btn: Button
    lateinit var insc: Button
    lateinit var Nom:EditText
    lateinit var Prenom:EditText
    lateinit var Niveau_scolaire:EditText
    lateinit var Email:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Nom = findViewById<EditText>(R.id.nom)
        Prenom = findViewById<EditText>(R.id.prenom)
        Niveau_scolaire = findViewById<EditText>(R.id.niveau_scolaire)
        Email = findViewById<EditText>(R.id.email)
        txv = findViewById<TextView>(R.id.forgot)

        val etud : Etudiant = Etudiant(Nom.text.toString(),Prenom.text.toString(),
                                        Niveau_scolaire.text.toString(),Email.text.toString())

        txv.setOnClickListener {

            val forgotIntent = Intent (applicationContext, Password_Forgot_Activity :: class.java )
            startActivity (forgotIntent)
        }

        btn = findViewById <Button> (R.id.login )
        btn.setOnClickListener {

            val connecterIntent = Intent (applicationContext, Connecter_Activity :: class.java )
            startActivity (connecterIntent)
        }

        insc = findViewById <Button> (R.id.inscription )
        insc.setOnClickListener {

            val inscriptionIntent = Intent (applicationContext, Inscription_Activity :: class.java )
            inscriptionIntent.putExtra("etud",etud)
            startActivity (inscriptionIntent)
        }
    }
}
