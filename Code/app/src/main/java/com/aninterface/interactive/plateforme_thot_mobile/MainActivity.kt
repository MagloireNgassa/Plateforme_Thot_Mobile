package com.aninterface.interactive.plateforme_thot_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txv: TextView
    lateinit var btn: Button
    lateinit var insc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txv = findViewById<TextView>(R.id.forgot)
        txv.setOnClickListener {

            val forgotIntent = Intent (applicationContext, Password_Forgot_Activity :: class. java )
            startActivity (forgotIntent)
        }

        btn = findViewById <Button> (R.id.login )
        btn.setOnClickListener {

            val connecterIntent = Intent (applicationContext, Connecter_Activity :: class. java )
            startActivity (connecterIntent)
        }

        insc = findViewById <Button> (R.id.inscription )
        insc.setOnClickListener {

            val connecterIntent = Intent (applicationContext, Inscription_Activity :: class. java )
            startActivity (connecterIntent)
        }
    }
}
