package com.xht.base_wa_lib.base

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.xht.base_lib.base.LazyVmFragment
import com.xht.base_lib.utils.StatusUtils
import com.xht.base_wa_lib.view.LoadingTip

abstract class BaseLazyLoadingFragment<BD : ViewDataBinding> : LazyVmFragment<BD>() {

    protected var gloding: LoadingTip? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseLoadingActivity) {
            gloding = context.loadingTip
        }
    }

    /**
     * 设置loadingView上下变局
     */
    protected fun setLoadingMargin(topMargin: Int, bottomMargin: Int) {
        val loadMarginTop = StatusUtils.getStatusBarHeight(mActivity) + topMargin
        val loadMarginBottom = StatusUtils.getNavigationBarHeight(mActivity) + bottomMargin
        val params = gloding?.layoutParams as ViewGroup.MarginLayoutParams
        params.topMargin = loadMarginTop
        params.bottomMargin = loadMarginBottom
        gloding?.layoutParams = params
    }
}