package com.allever.lib.permission.fast

import androidx.fragment.app.FragmentActivity

object FastPermission {

    private val PERMISSION_FRAGMENT_TAG = PermissionFragment::class.java.simpleName

    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        listener: PermissionListener?
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
        permissionFragment.request(*permissions, listener = listener)
    }

}