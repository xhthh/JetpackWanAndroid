package com.xht.jwa.ui.home

import com.xht.base_lib.base.BaseRepository
import com.xht.jwa.common.bean.ArticleListBean
import com.xht.jwa.http.ApiService
import com.xht.jwa.http.RetrofitManager

class HomeRepo : BaseRepository() {

    private var page: Int = 0

    /**
     * 获取置顶文章
     */
    suspend fun getTopArticles() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getTopList()
            .data()
            .let {
                //对模型转换
                ArticleListBean.trans(it)
            }
    }

    /**
     * 请求第一页
     */
    suspend fun getArticles() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getHomeList(page)
            .data()
            .datas?.let {
                ArticleListBean.trans(it)
            } ?: mutableListOf()
    }

    /**
     * 加载更多
     */
    suspend fun loadMoreArticles() = withIO {
        page++
        RetrofitManager.getApiService(ApiService::class.java)
            .getHomeList(page)
            .data()
            .datas?.let {
                ArticleListBean.trans(it)
            } ?: mutableListOf()
    }

    /**
     * 获取banner
     */
    suspend fun getBanner() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
            .data()
    }

}