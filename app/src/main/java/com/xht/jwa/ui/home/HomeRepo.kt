package com.xht.jwa.ui.home

import com.xht.base_lib.base.BaseRepository
import com.xht.jwa.http.ApiService
import com.xht.jwa.http.RetrofitManager

class HomeRepo : BaseRepository() {

    /**
     * 获取banner
     */
    suspend fun getBanner() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
            .data()
    }

}