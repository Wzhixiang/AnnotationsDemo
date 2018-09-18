package com.wzx.annotationsdemo.view.fragment

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
abstract class BaseDialogFragment : DialogFragment() {

    protected var mTitleTV: TextView? = null

    protected var mBackIV: ImageView? = null

    companion object {
        var TAG: String = BaseDialogFragment.javaClass.simpleName
    }

    abstract fun initWindow()

    @LayoutRes
    abstract fun setLayoutId(): Int

    abstract fun initView(@Nullable view: View?, @Nullable savedInstanceState: Bundle?)

    abstract fun initData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initWindow()
        return inflater!!.inflate(setLayoutId(), container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTitleTV = view!!.findViewById(R.id.tv_title)
        mBackIV = view!!.findViewById(R.id.iv_back)
        mBackIV!!.setOnClickListener {
            dismiss()
        }
        initView(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initData()
    }

    protected fun setTitle(title: String) {
        mTitleTV!!.text = title
    }
}