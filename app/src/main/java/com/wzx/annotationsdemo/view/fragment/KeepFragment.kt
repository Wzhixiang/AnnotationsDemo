package com.wzx.annotationsdemo.view.fragment

import android.os.Bundle
import android.support.annotation.Keep
import android.util.Log
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
class KeepFragment : BaseDialogFragment() {

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
        contentTV.text = getString(R.string.text_keep)

        setTitle(getString(R.string.text_title_keep))
    }

    //@Keep不混淆该方法
    @Keep
    fun keep() {
        Log.i(TAG, "保持方法不被混淆")
    }
}