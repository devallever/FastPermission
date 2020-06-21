package com.allever.app.permission.fast

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allever.lib.permission.fast.FastPermission
import com.allever.lib.permission.fast.PermissionListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FastPermission.request(
            this,
            object : PermissionListener {
                override fun onGrand() {

                }

                override fun onDeny() {

                }

                override fun onAlwaysDeny() {

                }
            },
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE
        )

        FastPermission.hasPermissions(
            this,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE
        );
    }
}