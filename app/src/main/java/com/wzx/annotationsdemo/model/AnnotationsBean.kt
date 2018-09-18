package com.wzx.annotationsdemo.model

import com.wzx.annotationsdemo.annotation.Way

/**
 * 描述：
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/17
 * 更新时间：
 * 更新内容：
 */
class AnnotationsBean {

    constructor(builder: Builder) {
        this.title = builder.title
        this.way = builder.way
    }

    var title: String
    var way: Int = 0

    class Builder {
        lateinit var title: String
        var way: Int = 0

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setWay(@Way.Companion.WayModel way: Int): Builder {
            this.way = way
            return this
        }

        fun build(): AnnotationsBean {
            return AnnotationsBean(this)
        }
    }
}