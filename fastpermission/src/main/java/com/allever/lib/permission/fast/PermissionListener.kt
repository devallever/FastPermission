package com.allever.lib.permission.fast

interface PermissionListener {
    fun onGrand()
    fun onDeny() {}
    fun onAlwaysDeny() {}
}