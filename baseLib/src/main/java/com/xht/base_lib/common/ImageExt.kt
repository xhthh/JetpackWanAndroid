package com.xht.base_lib.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.xht.base_lib.R
import com.xht.base_lib.view.GlideRoundTransform

fun ImageView.loadUrl(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}


/**
 * 圆形图片
 */
fun ImageView.loadRadius(context: Context, url: String, radius: Int = 20) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_launcher)
        .transition(DrawableTransitionOptions.withCrossFade())
        .transform(GlideRoundTransform(context, radius))
        .into(this)
}