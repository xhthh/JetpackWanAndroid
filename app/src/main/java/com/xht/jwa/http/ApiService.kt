package com.xht.jwa.http

import com.xht.jwa.ui.home.bean.BannerBean
import retrofit2.http.GET

interface ApiService {

    /**
     * banner
     */
    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<MutableList<BannerBean>>

}