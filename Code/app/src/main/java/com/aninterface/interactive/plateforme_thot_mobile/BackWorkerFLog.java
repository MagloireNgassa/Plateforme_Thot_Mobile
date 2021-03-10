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

public class BackWorkerFLog implements Runnable {

    private String login;
    private String password;
    private FirstLogin_Activity activity;


    public BackWorkerFLog( FirstLogin_Activity activity, String login, String password)
    {

        this.login = login;
        this.password = password;
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

            String msg = URLEncoder.encode("newLogin","utf-8")+"="+
                    URLEncoder.encode((String)this.login,"utf8")+"&"+
                    URLEncoder.encode("newPassword","utf-8")+"="+
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
