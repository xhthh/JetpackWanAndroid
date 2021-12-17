package com.xht.base_lib.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * 自定义DataBinding适配器
 */
object CustomBindAdapter {
    /**
     * 加载网络圆角图片
     */
    @BindingAdapter(value = ["imgUrlRadius"])
    @JvmStatic
    fun imgUrlRadiusCircle(view: ImageView, url: String) {
        view.loadRadius(view.context.applicationContext, url)
    }
}