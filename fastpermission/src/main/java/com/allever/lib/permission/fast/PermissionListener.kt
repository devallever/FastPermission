package com.allever.lib.permission.fast

public interface PermissionListener {
    public fun onGranted(grantedList: MutableList<String>)
    public fun onDenied(deniedList: MutableList<String>) {}
    public fun alwaysDenied(deniedList: MutableList<String>) {}
}