package com.xht.jwa.ui.home

import android.os.Bundle
import com.xht.base_wa_lib.base.BaseLazyLoadingFragment
import com.xht.jwa.R
import com.xht.jwa.databinding.FragmentHomeBinding

class HomeFragment:BaseLazyLoadingFragment<FragmentHomeBinding>() {
    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun lazyInit() {
    }

}