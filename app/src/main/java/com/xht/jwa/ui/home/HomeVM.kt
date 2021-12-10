package com.xht.jwa.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xht.base_lib.base.BaseViewModel
import com.xht.jwa.ui.home.bean.BannerBean

/**
 * 首页
 */
class HomeVM : BaseViewModel() {

    private val repo by lazy { HomeRepo() }

    /**
     * banner
     */
    private val _banner = MutableLiveData<MutableList<BannerBean>>()

    /**
     * 对外部提供只读的LiveData
     */
    val banner: LiveData<MutableList<BannerBean>> = _banner

    fun getBanner() {
        launch {
            _banner.value = repo.getBanner()
        }
    }

}