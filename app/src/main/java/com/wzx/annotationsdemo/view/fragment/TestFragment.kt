package com.wzx.annotationsdemo.view.fragment

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.annotation.VisibleForTesting.PRIVATE
import android.view.View
import android.view.Window
import android.widget.TextView
import com.wzx.annotationsdemo.R
import org.jetbrains.annotations.TestOnly

/**
 * 描述：
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/17
 * 更新时间：
 * 更新内容：
 */
class TestFragment : BaseDialogFragment() {

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
        contentTV.text = getString(R.string.text_test)

        setTitle(getString(R.string.text_title_test))

    }

    //@VisibleForTesting 没效果
    companion object {

        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        fun test1() {
            System.out.println("visible for testing：test1()")
        }

        @VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
        fun test2() {
            System.out.println("visible for testing：test2()")
        }

        @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
        fun test3() {
            System.out.println("visible for testing：test3()")
        }

        @VisibleForTesting(otherwise = VisibleForTesting.NONE)
        fun test4() {
            System.out.println("visible for testing：test4()")
        }

        fun test5() {
            System.out.println("visible for testing：test5()")
        }
    }
}