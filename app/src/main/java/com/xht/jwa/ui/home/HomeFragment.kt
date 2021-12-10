package com.xht.jwa.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import cn.bingoogolapple.bgabanner.BGABanner
import com.xht.base_lib.common.loadUrl
import com.xht.base_lib.common.toast
import com.xht.base_wa_lib.base.BaseLazyLoadingFragment
import com.xht.jwa.R
import com.xht.jwa.databinding.FragmentHomeBinding
import com.xht.jwa.ui.home.bean.BannerBean

class HomeFragment : BaseLazyLoadingFragment<FragmentHomeBinding>(),
    BGABanner.Adapter<ImageView?, String?>,
    BGABanner.Delegate<ImageView?, String?> {

    private var homeVM: HomeVM? = null

    private var bannerList: MutableList<BannerBean>? = null


    override fun initViewModel() {
        homeVM = getActivityViewModel(HomeVM::class.java)
    }

    override fun observe() {
        homeVM?.banner?.observe(this, Observer {
            bannerList = it
            initBanner()
        })
    }

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyInit() {
        initView()
        loadData()
    }

    override fun initView() {
        binding.vm = homeVM
    }

    override fun loadData() {
        homeVM?.getBanner()
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
        toast("点击了：$position")
        //        nav().navigate()
    }


}