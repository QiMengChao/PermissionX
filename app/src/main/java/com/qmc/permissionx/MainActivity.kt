package com.qmc.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.qmc.library.PermissionCallback
import com.qmc.library.PermissionX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.makeCallBtn).setOnClickListener {
            PermissionX.request(this,Manifest.permission.CALL_PHONE) {
                allGranted,deniedList ->
                if(allGranted) {
                    call()
                } else {
                    Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: Exception) {

        }
    }
}