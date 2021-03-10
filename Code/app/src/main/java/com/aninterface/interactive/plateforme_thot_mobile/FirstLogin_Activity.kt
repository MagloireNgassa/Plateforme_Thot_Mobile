package com.aninterface.interactive.plateforme_thot_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FirstLogin_Activity : AppCompatActivity() {

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
        setContentView(R.layout.activity_first_login_)

        Login = findViewById<EditText>(R.id.newUsername)
        Password = findViewById<EditText>(R.id.newPassword)
        btnConnexion = findViewById<Button>(R.id.update)

         btnConnexion.setOnClickListener{
             val baLog : BackWorkerFLog = BackWorkerFLog(this,Login.text.toString(),Password.text.toString())
             val t : Thread = Thread(baLog)
             t.start();
         }


    }
}
