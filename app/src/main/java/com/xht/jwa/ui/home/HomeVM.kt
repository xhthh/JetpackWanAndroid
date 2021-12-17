package com.xht.jwa.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.xht.base_lib.base.BaseViewModel
import com.xht.jwa.common.bean.ArticleListBean
import com.xht.jwa.ui.home.bean.BannerBean
import kotlinx.coroutines.async

/**
 * 首页
 */
class HomeVM : BaseViewModel() {

    private val repo by lazy { HomeRepo() }

    /**
     * 文章列表
     */
    private val _articleList = MutableLiveData<MutableList<ArticleListBean>>()

    /**
     * 对外部提供只读的LiveData
     */
    val articleList: LiveData<MutableList<ArticleListBean>> = _articleList

    /**
     * banner
     */
    private val _banner = MutableLiveData<MutableList<BannerBean>>()

    /**
     * 对外部提供只读的LiveData
     */
    val banner: LiveData<MutableList<BannerBean>> = _banner


    /**
     * 获取banner
     */
    fun getBanner() {
        launch {
            _banner.value = repo.getBanner()
        }
    }

    /**
     * 获取首页文章列表， 包括banner
     * viewModelScope.async{}
     * articles.await()
     */
    fun getArticle() {
        launch {
            val list = mutableListOf<ArticleListBean>()
            val topArticle = viewModelScope.async {
                repo.getTopArticles()
            }
            val articles = viewModelScope.async {
                repo.getArticles()
            }
            list.addAll(topArticle.await())
            list.addAll(articles.await())
            _articleList.value = list
        }
    }

    fun loadMoreArticle() {
        launch {
            val list = _articleList.value
            list?.addAll(repo.loadMoreArticles())
            _articleList.value = list

            //todo ？？？
//            handleList(_articleList)
        }
    }

}