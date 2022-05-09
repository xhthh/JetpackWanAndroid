package com.xht.jwa.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.SimpleItemAnimator
import cn.bingoogolapple.bgabanner.BGABanner
import com.xht.base_lib.common.loadUrl
import com.xht.base_lib.common.smartConfig
import com.xht.base_lib.common.smartDismiss
import com.xht.base_lib.common.toast
import com.xht.base_wa_lib.base.BaseLazyLoadingFragment
import com.xht.jwa.R
import com.xht.jwa.common.ArticleAdapter
import com.xht.jwa.databinding.FragmentHomeBinding
import com.xht.jwa.ui.home.bean.BannerBean

class HomeFragment : BaseLazyLoadingFragment<FragmentHomeBinding>(),
    BGABanner.Adapter<ImageView?, String?>,
    BGABanner.Delegate<ImageView?, String?> {

    private var homeVm: HomeVM? = null

    private var bannerList: MutableList<BannerBean>? = null

    private val adapter by lazy { ArticleAdapter(mActivity) }


    override fun initViewModel() {
        homeVm = getActivityViewModel(HomeVM::class.java)
    }

    override fun observe() {
        homeVm?.banner?.observe(this, Observer {
            bannerList = it
            initBanner()
        })

        //文章列表
        homeVm?.articleList?.observe(this, {
            binding.smartRefresh.smartDismiss()
            adapter.submitList(it)
            binding.loadingTip.dismiss()
        })
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyInit() {
        initView()
        loadData()
    }

    override fun initView() {
        binding.vm = homeVm
        //关闭更新动画
        (binding.rvHomeList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        binding.smartRefresh.setOnRefreshListener {
            homeVm?.getBanner()
//            homeVm?.getArticle()
        }
        //上拉加载
        binding.smartRefresh.setOnLoadMoreListener {
            homeVm?.loadMoreArticle()
        }
        binding.smartRefresh.smartConfig()
        adapter.apply {
            binding.rvHomeList.adapter = this
            setOnItemClickListener { i, view ->
                nav().navigate(
                    R.id.action_main_fragment_to_web_fragment,
                    this@HomeFragment.adapter.getBundle(i)
                )
            }
            setOnItemChildClickListener { i, view ->
                when (view.id) {
                    //收藏
                    R.id.ivCollect -> {
                        //todo 处理登录收藏的操作
                        toast("收藏")
                    }
                }
            }
        }
    }


    override fun loadData() {
        homeVm?.getBanner()
        homeVm?.getArticle()
        binding.loadingTip.loading()
    }

    /**
     * 初始化banner
     */
    private fun initBanner() {
        binding.banner.apply {
            setAutoPlayAble(true)
            val views: MutableList<View> = ArrayList()
            bannerList?.forEach { _ ->
                views.add(ImageView(mActivity).apply {
                    setBackgroundResource(R.drawable.ripple_bg)
                })
            }
            setAdapter(this@HomeFragment)
            setDelegate(this@HomeFragment)
            setData(views)
        }
    }

    override fun fillBannerItem(
        banner: BGABanner?,
        itemView: ImageView?,
        model: String?,
        position: Int
    ) {
        itemView?.apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            loadUrl(mActivity, bannerList?.get(position)?.imagePath!!)
        }
    }

    override fun onBannerItemClick(
        banner: BGABanner?,
        itemView: ImageView?,
        model: String?,
        position: Int
    ) {
        nav().navigate(R.id.action_main_fragment_to_web_fragment, Bundle().apply {
            bannerList?.get(position)?.let {
                putString("loadUrl", it.url)
                putString("title", it.title)
                putInt("id", it.id)
            }
        })
    }


}