package com.wzx.annotationsdemo.view.fragment

import android.os.Build
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.annotation.RequiresApi
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
class NullNessFragment : BaseDialogFragment() {

    lateinit var contentTV: TextView

    @RequiresApi(Build.VERSION_CODES.M)
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
        contentTV.setText(R.string.text_nullness)

        setTitle(getString(R.string.text_title_nullness))
    }

    @Nullable
    fun a(@NonNull string: String): String? {
        return null
    }
}