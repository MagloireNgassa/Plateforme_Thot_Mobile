package com.aninterface.interactive.plateforme_thot_mobile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackWorkerIns implements Runnable {
    private String nom;
    private String prenom;
    private String niveau_scolaire;
    private String email;
    private String login;
    private String password;
    private Inscription_Activity activity;


    public BackWorkerIns( Inscription_Activity activity, Etudiant etudiant)
    {
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.niveau_scolaire = etudiant.getNiveau_scolaire();
        this.email = etudiant.getEmail();
        this.login = etudiant.getEmail();
        this.password = etudiant.getNom() +"12345";
        this.activity = activity;

    }
    @Override
    public void run() {
        String cible = "http://192.168.2.11/APP_Mob/plateforme_Thot/inscription.php";
        String runReponse;
        try
        {
            URL url = new URL(cible);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            OutputStream outs = con.getOutputStream();
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(outs,"utf-8"));

            String msg = URLEncoder.encode("nom","utf-8")+"="+
                    URLEncoder.encode((String)this.nom,"utf8")+"&"+
                    URLEncoder.encode("prenom","utf-8")+"="+
                    URLEncoder.encode((String)this.prenom,"utf8")+"&"+
                    URLEncoder.encode("niveau_scolaire","utf-8")+"="+
                    URLEncoder.encode((String)this.niveau_scolaire,"utf8")+"&"+
                    URLEncoder.encode("email","utf-8")+"="+
                    URLEncoder.encode((String)this.email,"utf8")+"&"+
                    URLEncoder.encode("login","utf-8")+"="+
                    URLEncoder.encode((String)this.login,"utf8")+"&"+
                    URLEncoder.encode("password","utf-8")+"="+
                    URLEncoder.encode((String)this.password,"utf8");

            bufw.write(msg);
            bufw.flush();
            bufw.close();
            outs.close();

            InputStream ins = con.getInputStream();
            BufferedReader bufr = new BufferedReader(new InputStreamReader(ins,"iso-8859-1"));
            String line;
            StringBuffer sbuff = new StringBuffer();

            while ((line = bufr.readLine()) !=null)
            {
                sbuff.append(line );
            }
             runReponse = sbuff.toString();
        }
        catch (Exception ex)
        {
             runReponse = ex.getMessage();
        }

        this.activity.reponse(runReponse);

    }
}
