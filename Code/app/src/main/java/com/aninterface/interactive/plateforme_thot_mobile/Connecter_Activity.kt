package com.aninterface.interactive.plateforme_thot_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_connecter_.*

class Connecter_Activity : AppCompatActivity() {

    lateinit var reponses: String
    fun  reponse(reponse:String)
    {
        this.reponses = reponse
    }

    lateinit var btnConnexion: Button
    lateinit var Login: EditText
    lateinit var Password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connecter_)

        Login = findViewById<EditText>(R.id.username)
        Password = findViewById<EditText>(R.id.password)
        btnConnexion = findViewById<Button>(R.id.connexion)

        val loginText:String = Login.text.toString()

        val baLog : BackWorkerLog = BackWorkerLog(this,Login.text.toString(),Password.text.toString())
        val t : Thread = Thread(baLog)
        t.start();
    }
}
