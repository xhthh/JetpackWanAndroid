package com.xht.base_lib.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding

/**
 * 基于androidx 实现懒加载
 */
abstract class LazyVmFragment<BD : ViewDataBinding> : BaseVmFragment<BD>() {
    private var isLoaded = false
    override fun onResume() {
        super.onResume()
        //增加了Fragment是否可见的判断
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        }
    }

    override fun init(savedInstanceState: Bundle?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()
}