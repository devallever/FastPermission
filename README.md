# FastPermission

Android运行时请求权限

- 申请权限

```
        FastPermission.request(
            this,
            object : PermissionListener {
                override fun onGrand() {
                    //全部授权
                }

                override fun onDeny() {
                    //部分拒绝
                }

                override fun onAlwaysDeny() {
                    //不再提示
                }
            },
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE
        )
```

- 判断使用有权限

```
        val hasPermission = FastPermission.hasPermissions(
            this,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE
        )
```

- 判断是否总是拒绝（不再提示）

```
        val alwaysDeny = FastPermission.hasAlwaysDeny(
            this, Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE
        )
```