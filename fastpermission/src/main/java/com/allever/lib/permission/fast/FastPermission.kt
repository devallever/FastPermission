package com.allever.lib.permission.fast

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

object FastPermission {

    private val PERMISSION_FRAGMENT_TAG = PermissionFragment::class.java.simpleName

    fun request(
        activity: FragmentActivity,
        listener: PermissionListener?,
        vararg permissions: String
    ) {
        val fragmentManager = activity.supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(PERMISSION_FRAGMENT_TAG)
        val permissionFragment = if (fragment == null) {
            val newFragment = PermissionFragment()
            fragmentManager.beginTransaction().add(newFragment, PERMISSION_FRAGMENT_TAG).commitNow()
            newFragment
        } else {
            fragment as PermissionFragment
        }
        permissionFragment.request(listener, *permissions)
    }

    fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        for (permission in permissions) {
            val result = ContextCompat.checkSelfPermission(context, permission)
            if (result == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    }

    fun hasAlwaysDeny(activity: Activity, permission: String): Boolean {
        return !shouldShowRequestPermissionRationale(activity, permission)
    }

}