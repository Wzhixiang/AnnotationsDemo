package com.wzx.annotationsdemo.view.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.support.annotation.CheckResult
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
class CheckFragment : BaseDialogFragment() {

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
        contentTV.text = getString(R.string.text_check)

        setTitle(getString(R.string.text_title_check))

        val bitmap = getBitmap()

        setBitmap(null)
    }

    /**
     * 没有警告返回值
     */
    @CheckResult
    fun getBitmap(): Bitmap? {
        return null
    }

    /**
     * 返回值警告
     */
    @CheckResult(suggest = "fun 'setBitmap(b: Bitmap)' return value is null")
    fun setBitmap(b: Bitmap?) = null
}