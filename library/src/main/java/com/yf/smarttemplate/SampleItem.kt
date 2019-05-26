package com.yf.smarttemplate

import android.content.Context
import java.io.Serializable

/**
 * sample基类，包含具体item和container
 *
 * Created by yf.
 * @date 2019-05-26
 */
open class SampleItem(var title: String = "", var desc: String = "") : Serializable

/**
 * 打开activity的item
 */
class ActivitySampleItem(val clazz: Class<*>) : SampleItem()

/**
 * 可直接执行的item
 */
class ExecutionSampleItem : SampleItem() {
    /**
     * 闭包类型
     */
    internal var execution: ((Context) -> Unit)? = null

    /**
     * DSL 执行这段代码
     */
    fun execute(closure: (Context) -> Unit) {
        execution = closure
    }
}