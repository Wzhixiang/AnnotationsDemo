package com.wzx.annotationsdemo.annotation

import android.support.annotation.IntDef

/**
 * 描述：类型定义注解
 * <p>const相当于java中的static</p>
 * 创建人： Administrator
 * 创建时间： 2018/9/17
 * 更新时间：
 * 更新内容：
 */
class Way {

    companion object {
        const val NULLNESS_ANNOTATION = 0
        const val RES_ANNOTATION = 1
        const val Type_ANNOTATION = 2
        const val Thread_ANNOTATION = 3
        const val Value_ANNOTATION = 4
        const val Permission_ANNOTATION = 5
        const val Override_ANNOTATION = 6
        const val Check_ANNOTATION = 7
        const val Test_ANNOTATION = 8
        const val Keep_ANNOTATION = 9

        @IntDef(NULLNESS_ANNOTATION, RES_ANNOTATION, Type_ANNOTATION, Thread_ANNOTATION,
                Value_ANNOTATION, Permission_ANNOTATION, Override_ANNOTATION, Check_ANNOTATION,
                Test_ANNOTATION, Keep_ANNOTATION)
        @Retention(AnnotationRetention.SOURCE)
        annotation class WayModel
    }

}