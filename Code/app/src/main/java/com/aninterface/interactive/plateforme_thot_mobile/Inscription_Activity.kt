package com.aninterface.interactive.plateforme_thot_mobile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inscription_.*

class Inscription_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription_)

        //button click
        img_pick_btn.setOnClickListener{
            //verification de la permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_DENIED){
                    //permission refusé
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //info bulle pour la reponse a la permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else {
                    //permission accepté
                    pickImageFromGallery();
                }
            }
            else {
                // systeme os is < Marshmallo
                pickImageFromGallery();
            }

        }

    }

    private fun pickImageFromGallery() {
        val intent = Intent (Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;

        //permission code
        private val PERMISSION_CODE = 1001;

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
         when (requestCode){
             PERMISSION_CODE -> {
                 if (grantResults.size >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                     //permission from popup granted
                     pickImageFromGallery()
                 }
                 else{
                     //permission from popup denied
                     Toast.makeText(this,"Permission refusé", Toast.LENGTH_SHORT).show()
                 }
             }
         }
    }

    override fun onActivityResult (requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
             image_view.setImageURI(data?.data)
         }
    }
}
