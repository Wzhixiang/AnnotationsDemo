package com.wzx.annotationsdemo.annotation

import android.support.annotation.StringDef

/**
 * 描述：
 *
 * 创建人： Administrator
 * 创建时间： 2018/9/18
 * 更新时间：
 * 更新内容：
 */
class Week {

    companion object {
        const val Monday = "星期一"
        const val Tuesday = "星期二"
        const val Wednesday = "星期三"
        const val Thursday = "星期四"
        const val Friday = "星期五"
        const val Saturday = "星期六"
        const val Sunday = "星期日"

        @StringDef(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
        @Retention(AnnotationRetention.SOURCE)
        annotation class WeekModel
    }
}