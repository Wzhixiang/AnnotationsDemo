package com.wzx.annotationsdemo.view.fragment

import android.os.Bundle
import android.support.annotation.FloatRange
import android.support.annotation.IntRange
import android.support.annotation.Size
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
class ValueFragment : BaseDialogFragment() {

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
        contentTV.text = getString(R.string.text_value)

        setTitle(getString(R.string.text_title_value))

        minLength("1")
        maxLength("11")
        lengthSection("111")
        lengthEquals2("11")
        lengthMutiple("1111")

        intRange(10)
        floatRange(10f)
    }

    /**
     * 长度必须大于1
     */
    fun minLength(@Size(min = 1) str: String) {
        log(str)
    }

    /**
     * 长度最大为2
     */
    fun maxLength(@Size(max = 2) str: String) {
        log(str)
    }

    /**
     * 长度必须在区间[1,3]
     */
    fun lengthSection(@Size(min = 1, max = 3) str: String) {
        log(str)
    }

    /**
     * 长度必须等于2
     */
    fun lengthEquals2(@Size(2) str: String) {
        log(str)
    }

    /**
     * 长度必须是2的倍数
     */
    fun lengthMutiple(@Size(multiple = 2) str: String) {
        log(str)
    }

    fun log(msg: String) {
        Log.i("ValueFragment", msg)
    }

    /**
     * 限定int取值范围
     */
    fun intRange(@IntRange(from = 0, to = 100) value: Int) {

    }

    /**
     * 限定float取值范围
     */
    fun floatRange(@FloatRange(from = 0.0, to = 100.0) value: Float) {

    }
}