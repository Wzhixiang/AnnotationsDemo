package com.wzx.annotationsdemo.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.wzx.annotationsdemo.R
import com.wzx.annotationsdemo.adapter.AnnotationsAdapter
import com.wzx.annotationsdemo.annotation.Way
import com.wzx.annotationsdemo.model.AnnotationsBean
import com.wzx.annotationsdemo.view.fragment.*

/**
 * 参考：
 * https://blog.csdn.net/Gaugamela/article/details/79377778
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: AnnotationsAdapter

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = AnnotationsAdapter()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter

        mAdapter.setOnItemClickListener(object : AnnotationsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, annotation: AnnotationsBean) {
                showFragment(annotation.way)
            }
        })
    }

    override fun onStart() {
        super.onStart()

        mAdapter.newData(createData())
    }

    fun createData(): ArrayList<AnnotationsBean> {
        var list: ArrayList<AnnotationsBean> = ArrayList()
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_nullness))
                .setWay(Way.NULLNESS_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_res))
                .setWay(Way.RES_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_type))
                .setWay(Way.Type_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_thread))
                .setWay(Way.Thread_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_value))
                .setWay(Way.Value_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_permission))
                .setWay(Way.Permission_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_override))
                .setWay(Way.Override_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_check))
                .setWay(Way.Check_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_test))
                .setWay(Way.Test_ANNOTATION)
                .build())
        list.add(AnnotationsBean.Builder()
                .setTitle(getString(R.string.text_title_keep))
                .setWay(Way.Keep_ANNOTATION)
                .build())


        return list
    }

    /**
     * 展示弹窗
     */
    fun showFragment(@Way.Companion.WayModel way: Int) {
        when (way) {
            Way.NULLNESS_ANNOTATION -> {
                NullNessFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.RES_ANNOTATION -> {
                ResFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Type_ANNOTATION -> {
                TypeFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Thread_ANNOTATION -> {
                ThreadFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Value_ANNOTATION -> {
                ValueFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Permission_ANNOTATION -> {
                PermissionFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Override_ANNOTATION -> {
                OverrideFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Check_ANNOTATION -> {
                CheckFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Test_ANNOTATION -> {
                TestFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            Way.Keep_ANNOTATION -> {
                KeepFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
            else -> {
                NullNessFragment().show(supportFragmentManager, BaseDialogFragment.TAG)
            }
        }
    }
}
