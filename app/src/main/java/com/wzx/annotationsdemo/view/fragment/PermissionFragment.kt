package com.wzx.annotationsdemo.view.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.hardware.fingerprint.FingerprintManager
import android.net.Uri
import android.os.Bundle
import android.support.annotation.RequiresPermission
import android.view.View
import android.view.Window
import android.widget.TextView
import com.wzx.annotationsdemo.R

/**
 * 描述：
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/17
 * 更新时间：
 * 更新内容：
 */
class PermissionFragment : BaseDialogFragment() {

    lateinit var contentTV: TextView

    override fun initWindow() {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setCanceledOnTouchOutside(false)
    }

    override fun setLayoutId(): Int {
        return R.layout.dialogfragment_content
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        contentTV = view!!.findViewById(R.id.tv_content)
    }

    override fun initData() {
        contentTV.text = getString(R.string.text_permission)

        setTitle(getString(R.string.text_title_permission))

        permission()

        permissionAll()

        permissionAny()
    }

    //访问这个方法需要声明INTERNET权限
    @RequiresPermission(Manifest.permission.INTERNET)
    fun permission() {

    }

    //访问这个方法需要声明INTERNET、ACCESS_COARSE_LOCATION权限所有权限
    @RequiresPermission(allOf = [Manifest.permission.INTERNET, Manifest.permission.ACCEPT_HANDOVER], conditional = true)
    fun permissionAll() {

    }

    //访问这个方法需要声明INTERNET、ACCESS_COARSE_LOCATION权限中任意权限
    @RequiresPermission(anyOf = [Manifest.permission.INTERNET, Manifest.permission.ACCEPT_HANDOVER], conditional = true)
    fun permissionAny() {

    }

    //对于ContentProvider可能需要读和写这两个操作，对应不同的权限声明
    @RequiresPermission.Read(RequiresPermission("read_permission"))
    @RequiresPermission.Write(RequiresPermission("write_permission"))
    val TEST_URI = Uri.parse("content://test/info")
}