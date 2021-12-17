package com.xht.jwa.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.xht.jwa.R

/**
 * 文章列表dataBinding适配器
 */
object ArticleBindAdapter {
    @BindingAdapter(value = ["articleCollect"])
    @JvmStatic
    fun imgPlayBlur(view: ImageView, collect: Boolean) {
        if (collect) {
            view.setImageResource(R.mipmap._collect)
        } else {
            view.setImageResource(R.mipmap.un_collect)
        }
    }
}