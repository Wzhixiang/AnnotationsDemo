package com.wzx.annotationsdemo.adapter

import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wzx.annotationsdemo.R
import com.wzx.annotationsdemo.model.AnnotationsBean

/**
 * 描述：
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/17
 * 更新时间：
 * 更新内容：
 */
class AnnotationsAdapter() : RecyclerView.Adapter<AnnotationsAdapter.VH>() {

    private var mData: ArrayList<AnnotationsBean>

    @Nullable
    private lateinit var mListener: OnItemClickListener

    init {
        mData = ArrayList()
    }

    constructor(mData: ArrayList<AnnotationsBean>) : this() {
        this.mData = mData
    }

    fun newData(list: ArrayList<AnnotationsBean>) {
        mData.clear()
        mData.addAll(list)
        notifyDataSetChanged()
    }


    interface OnItemClickListener {
        fun onItemClick(position: Int, annotation: AnnotationsBean)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_annotations, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.nameTV.text = mData[position].title

        holder.itemView.setOnClickListener {
            if (mListener != null) {
                mListener.onItemClick(position, mData[position])
            }
        }
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTV: TextView

        init {
            nameTV = itemView.findViewById(R.id.tv_name)
        }
    }
}