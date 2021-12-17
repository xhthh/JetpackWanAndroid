package com.xht.jwa.http

import com.xht.jwa.common.bean.ArticleBean
import com.xht.jwa.ui.home.bean.BannerBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     * 获取首页文章数据
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeList(@Path("page") pageNo: Int): ApiResponse<ArticleBean>

    /**
     * 获取首页置顶文章数据
     */
    @GET("/article/top/json")
    suspend fun getTopList(): ApiResponse<MutableList<ArticleBean.DatasBean>>

    /**
     * banner
     */
    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<MutableList<BannerBean>>

}