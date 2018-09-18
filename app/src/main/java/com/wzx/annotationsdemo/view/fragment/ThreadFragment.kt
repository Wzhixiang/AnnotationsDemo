package com.wzx.annotationsdemo.view.fragment

import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.support.annotation.*
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
class ThreadFragment : BaseDialogFragment() {

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
        contentTV.setText(R.string.text_thread)

        setTitle(getString(R.string.text_title_thread))

        doTask1()
        doTask2()
        doTask3()
    }

    fun isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Log.i("ThreadFragment", "主线程")
        } else {
            Log.i("ThreadFragment", "子线程")
        }
    }

    @UiThread
    fun doTask1() {
        isMainThread()
    }

    @MainThread
    fun doTask2() {
        isMainThread()
    }

    @WorkerThread
    fun doTask3() {
        Thread(Runnable {
            isMainThread()
        }).start()
    }

    @BinderThread
    fun doTask4() {

    }
}